package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import selenium.FirefoxBrowser;

public class FirefoxSteps {

  FirefoxBrowser firefoxBrowser;

  @After(value = "@CloseFirefox", order = -1)
  public void CloseFirefox() {
    firefoxBrowser.closeChrome();
  }

  @And("I open Google page in Firefox")
  public void openGooglePageInFirefox() {
    firefoxBrowser = new FirefoxBrowser();
    firefoxBrowser.openGoogle();
  }

  @And("the Title on Google page in Firefox should be {string}")
  public void titleOnGooglePageInFirefoxShouldBe(String expected) {
    Assert.assertEquals(expected, firefoxBrowser.getTitle());
  }

  /**
   * Test Adds
   */
  @After(value = "@TakeScreenshotFirefox",order = 0)
  public void takeScreenshotOnFailure(Scenario scenario) {
    byte[] src = null;
    if (scenario.isFailed()) {

      TakesScreenshot ts = (TakesScreenshot) firefoxBrowser.getDriver();

      src = ts.getScreenshotAs(OutputType.BYTES);
      scenario.attach(src, "image/png", "screenshot");
      Allure.addAttachment("Error", new ByteArrayInputStream(src));
    }
  }
}
