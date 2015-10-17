*** Settings ***
Library     Selenium2Library

*** Variables ***
${URL}      localhost:8080/fizzbuzz/index.html
${BROWSER}  Firefox
${DELAY}    0
${TITLE}    FizzBuzz

*** Keywords ***
Open Browser to Application Page
    Open Browser    ${URL}    ${BROWSER}
    #Maximize Browser Window
    Set Selenium Speed    ${DELAY}
   # Application Page Should Be Open

Application Page Should Be Open
    Title Should Be     ${TITLE}

Input Data      [Arguments]    ${triple}
    Input Text  input_data  triple

Submit Data
    Click Button    submit_button

Check Result    [Arguments] ${expected}
    Element Should Contain    fizz_buzz_result    ${expected}
