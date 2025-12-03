*** Settings ***
Resource         keywords.robot
Test Teardown    Close Test Browser

*** Test Cases ***
Verify Successful Login With Standard User
    [Documentation]    Verifies that standard user can login successfully
    ...    - testrail_case_field: refs:TR-1
    ...    - testrail_case_field: priority_id:1
    ...    - testrail_result_field: custom_environment:qa
    Open SauceDemo Website
    Verify Login Page Loaded
    Login With Credentials    ${STANDARD_USER}    ${VALID_PASSWORD}
    Verify Successful Login

Verify Products Page After Login
    [Documentation]    Verifies that products page is displayed after successful login
    ...    - testrail_case_field: refs:TR-2
    ...    - testrail_case_field: priority_id:2
    ...    - testrail_result_field: custom_environment:qa
    Open SauceDemo Website
    Login With Credentials    ${STANDARD_USER}    ${VALID_PASSWORD}
    Verify Successful Login
    Verify Products Page Title

