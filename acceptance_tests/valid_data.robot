*** Settings *** 
Suite Setup     Open Browser to Application Page
Suite Teardown  Close Browser
Resource        resource.robot

*** Test cases ***
Works for single input
    Input Data   3 5 10
    Submit Data
    Check Result    1 2 F 4 B F 7 8 F

Works for multiple lines input
    Input Data    3 5 10\n2 7 5
    Submit Data
    Check Result    1 2 F 4 B F 7 8 F B\n1 F 3 F 5 F B F 9 F 11 F 13 FB 5



