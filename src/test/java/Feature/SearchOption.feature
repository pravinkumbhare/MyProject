Feature: Search Action

  @RegressionTest @SmokeTest @SingleTestcase
  Scenario Outline: : Search Employee Name from search option
    Given Open apps and User Navigate to LogIn Page.
    When Search an "<Employee_Name>"
    Then Employee name should be displayed in searched option
    Examples:
      | Employee_Name |
      | Pravin Kumbhare |


