package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import selenium.ChromeBrowser;
import utils.StringUtils;

public class UtilsSteps {

  ChromeBrowser chromeBrowser;

  @And("the {string} text get a number it should be equal to {string}")
  public void theTextGetANumberItShouldBeEqualTo(final String text, final String expectedNumber) {
    final String actualNumber = StringUtils.getNumbersFromText(text);
    Assert.assertEquals(actualNumber, expectedNumber);
  }

  @And("I open Google page")
  public void iOpenGooglePage() {
    chromeBrowser = new ChromeBrowser();
    chromeBrowser.openGoogle();
  }

  @After(value = "@CloseChrome", order = -1)
  public void closeChrome() {
    chromeBrowser.closeChrome();
  }

  @Step
  @And("the Title on Google page should be {string}")
  public void theTitleOnGooglePageShouldBe(String expected) {
    Assert.assertEquals(expected, chromeBrowser.getTitle());
  }


  /**
   * Test Adds
   */
  @After(order = 0)
  public void takeScraenshotOnFailure(Scenario scenario) {
    byte[] src = null;
    if (scenario.isFailed()) {

      TakesScreenshot ts = (TakesScreenshot) chromeBrowser.getDriver();

      src = ts.getScreenshotAs(OutputType.BYTES);
      scenario.attach(src, "image/png", "screenshot");
      Allure.addAttachment("Error", new ByteArrayInputStream(src));
    }

  }
}
