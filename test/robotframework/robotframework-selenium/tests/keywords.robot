*** Settings ***
Library          SeleniumLibrary

*** Variables ***
${BASE_URL}           https://www.saucedemo.com
${STANDARD_USER}      standard_user
${VALID_PASSWORD}     secret_sauce

*** Keywords ***
Set TestRail Property
    [Arguments]    ${key}    ${value}
    Set Test Documentation    ${\n}- ${key}: ${value}    append=True

Open SauceDemo Website    
    Open Browser
    ...    url=${BASE_URL}
    ...    browser=headlesschrome
    Set Window Size    1920    1080

Input Username
    [Arguments]    ${username}
    Wait Until Element Is Visible    id=user-name
    Input Text    id=user-name    ${username}

Input Password
    [Arguments]    ${password}
    Wait Until Element Is Visible    id=password
    Input Text    id=password    ${password}

Click Login Button
    Click Element    id=login-button

Verify Login Page Loaded
    Wait Until Element Is Visible    id=login-button
    Element Should Be Visible    id=user-name
    Element Should Be Visible    id=password

Verify Successful Login
    Wait Until Element Is Visible    css=.inventory_list    timeout=10s
    Location Should Contain    inventory.html
    Element Should Be Visible    css=.app_logo
    Set TestRail Property    testrail_result_comment    Login successful - inventory page displayed

Verify Products Page Title
    Wait Until Element Is Visible    css=.title
    Element Should Contain    css=.title    Products

Login With Credentials
    [Arguments]    ${username}    ${password}
    Input Username    ${username}
    Input Password    ${password}
    Click Login Button

Take Screenshot And Report
    ${path} =    Capture Page Screenshot    filename=failure-{index}.png
    Set TestRail Property    testrail_attachment    ${path}

Close Test Browser
    Run Keyword If    '${TEST_STATUS}' != 'PASS'    Take Screenshot And Report
    Close Browser
