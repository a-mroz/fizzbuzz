*** Settings *** 
Suite Setup     Open Browser to Application Page
Suite Teardown  Close Browser
Resource        resource.robot


*** Variables ***
${input1}    3 5 10
${expectedOutput1}    1 2 F 4 B F 7 8 F B
${input2}    2 7 15
${expectedOutput2}    1 F 3 F 5 F B F 9 F 11 F 13 FB 15


*** Test cases ***
Works for single input
    Input Data   ${input1}
    Submit Data
    Check Result    ${input1}    ${expectedOutput1}

Works for multiple lines input
    Input Data    ${input1}\n${input2}
    Submit Data
    Check Result    ${input1}    ${expectedOutput1}
    Check Result    ${input2}    ${expectedOutput2}



