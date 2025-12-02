import http from 'k6/http';
import { check, group } from 'k6';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.1.0/index.js';

const baseUrl = 'http://jsonplaceholder.typicode.com';

export const options = {
  vus: 1,
  stages: [{ duration: '10s', target: 10 }],
  thresholds: {
    http_req_failed: ['rate<0.01'],
    http_req_duration: ['p(95)<3000'],
    http_reqs: ['count >= 50'],
  },
};

export default function () {
  group('Posts API', function () {
    const res = http.get(`${baseUrl}/posts`);
    check(res, {
      'C1 - status is 200': (r) => r.status === 200,
      'C2 - response < 2s': (r) => r.timings.duration < 2000,
    });
  });

  group('Users API', function () {
    const res = http.get(`${baseUrl}/users`);
    check(res, {
      'C3 - status is 200': (r) => r.status === 200,
      'C4 - has 10 users': (r) => r.json().length === 10,
    });
  });

  group('Comments API', function () {
    const res = http.get(`${baseUrl}/comments?postId=1`);
    check(res, {
      'C5 - status is 200': (r) => r.status === 200,
    });
  });
}

// 生成 JUnit 报告（TRCLI 兼容）
export function handleSummary(data) {
  const checks = [];
  (function walk(g, p) {
    (g.checks || []).forEach(c => {
      const name = p ? `${p} > ${c.name}` : c.name;
      const fail = c.fails > 0 ? `<failure>Failed ${c.fails}/${c.passes + c.fails}</failure>` : '';
      checks.push(`<testcase name="${name.replace(/[<>&"]/g, c => ({'<':'&lt;','>':'&gt;','&':'&amp;','"':'&quot;'}[c]))}">${fail}</testcase>`);
    });
    (g.groups || []).forEach(sg => walk(sg, p ? `${p} > ${sg.name}` : sg.name));
  })(data.root_group, '');

  return {
    'reports/junit-report.xml': `<?xml version="1.0"?>\n<testsuites><testsuite name="k6" tests="${checks.length}">\n${checks.join('\n')}\n</testsuite></testsuites>`,
    stdout: textSummary(data, { indent: ' ', enableColors: true }),
  };
}