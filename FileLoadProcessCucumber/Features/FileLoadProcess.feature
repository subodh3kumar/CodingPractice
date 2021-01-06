Feature: File Load Process

  Scenario Outline: Verify Different Types of Files in a Directory
    Given browse the file "<directory>"
    When load the file
    Then get the file name
    Then verify file is empty or not
    Then get the file information

    Examples:
      | directory                               |
      | /Development/Files/Input/Cucumber       |
      #| /Development/Files/Input/Cucumber/Input |

