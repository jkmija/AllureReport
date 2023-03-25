package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.testng.Assert;
import selenium.FirefoxBrowser;

public class FirefoxSteps {

  FirefoxBrowser firefoxBrowser;

  @After(value = "@CloseFirefox")
  public void CloseFirefox() {
    firefoxBrowser.closeChrome();
  }

  @And("I open Google page in Firefox")
  public void openGooglePageInFirefox() {
    firefoxBrowser = new FirefoxBrowser();
  }

  @And("the Title on Google page in Firefox should be {string}")
  public void titleOnGooglePageInFirefoxShouldBe(String expected) {
    Assert.assertEquals(expected, firefoxBrowser.getTitle());
  }
}
