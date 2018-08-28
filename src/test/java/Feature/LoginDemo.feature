@SmokeTest
Feature: Login Action

  Scenario Outline: : Successful Login with Valid Credentials
    Given Open apps and User Navigate to LogIn Page
    When Enter valid "<username>" and "<password>"
    Then Message displayed Login Successfully

    Examples:
      | username                           | password   |
      | pravin.kumbhare@globallogic.com     | Pr@vin_2021 |


  Scenario Outline: Upload a file

    Given that the user is on upload file screen.
    When a user clicks on the Browse button.
    And user enters <filename> onto the upload textbox.
    And user clicks on the enter button.
    Then verify that the file upload is successful.

    Examples:

      |filename|
      |file1|
      |file2|


