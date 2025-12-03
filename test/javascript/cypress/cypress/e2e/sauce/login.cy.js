/// <reference types="cypress" />

describe('SauceDemo Login', () => {
  beforeEach(() => {
    cy.visit('https://www.saucedemo.com')
  })

  it('should display login page correctly', () => {
    // 验证登录页面元素
    cy.get('#user-name').should('be.visible')
  })

  it('should login successfully with standard user', () => {
    // 输入有效凭据
    cy.get('#user-name').type('standard_user')
    cy.get('#password').type('secret_sauce')
    cy.get('#login-button').click()

    // 验证登录成功 - 跳转到商品页面
    cy.url().should('include', '/inventory.html')
    cy.get('.title').should('have.text', 'Products')
    cy.get('.inventory_list').should('be.visible')
    cy.get('.inventory_item').should('have.length.at.least', 1)
  })

  it('should show error message with invalid credentials', () => {
    // 输入无效凭据
    cy.get('#user-name').type('invalid_user')
    cy.get('#password').type('wrong_password')
    cy.get('#login-button').click()

    // 验证错误提示
    cy.get('[data-test="error"]')
      .should('be.visible')
      .and('contain', 'Username and password do not match')
  })
})