package utils;

public class StringUtils {
  private StringUtils(){}

  /**
   * Gets only numbers from text.
   *
   * <p>For example: The price is 10 &gt; returns: 10.
   *
   * @param value is a string with letters and numbers.
   * @return string with only numbers.
   */
  public static String getNumbersFromText(String value) {
    return value.replaceAll("\\D", "");
  }
}
