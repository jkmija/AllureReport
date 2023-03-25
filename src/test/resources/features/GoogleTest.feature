@Test
Feature: Google test


  @Test-2 @TakesScreenshotChrome @CloseChrome
  Scenario: Verifies Google page is displayed
    And I open Google page
    And the Title on Google page should be "Google2"


  @Test-3 @TakeScreenshotFirefox
  Scenario: Verifies Google page is displayed in Firefox browser
    And I open Google page in Firefox
    And the Title on Google page in Firefox should be "Googlex"