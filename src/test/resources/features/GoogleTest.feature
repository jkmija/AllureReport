@Test
Feature: Google test


  @Test-2 @CloseChrome
  Scenario: Verifies Google page is displayed
    And I open Google page
    And the Title on Google page should be "Google2"


  @Test-3
  Scenario: Verifies Google page is displayed
    And I open Google page in Firefox
    And the Title on Google page in Firefox should be "Googlex"