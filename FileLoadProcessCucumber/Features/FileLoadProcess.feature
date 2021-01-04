Feature: File Load Process
  Scenario: Verify Different Types of Files in a Directory
    Given browse file location "<fileLocation>"
    When load the file
    Then get the type of file
    Then verify file is empty or not
    Then display the file header

