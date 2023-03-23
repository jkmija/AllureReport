package utils;


import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

class StringUtilsTest {

  /**
   * Test to delete letter in a String.
   */
  public void deleteLetters() {
    final String actual = StringUtils.getNumbersFromText("2nd");
    final String expected = "2";
    Assert.assertEquals(String.format("Expected : %s are not equals actual: %s", expected, actual),
        expected, actual);
  }
}