package steps;

import io.cucumber.java.en.And;
import org.testng.Assert;
import utils.StringUtils;

public class UtilsSteps {


  @And("the {string} text get a number it should be equal to {string}")
  public void theTextGetANumberItShouldBeEqualTo(final String text, final String expectedNumber) {
    final String actualNumber = StringUtils.getNumbersFromText(text);
    Assert.assertEquals(actualNumber,expectedNumber);
  }
}
