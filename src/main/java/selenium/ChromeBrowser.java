package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {

  public WebDriver getDriver() {
    return driver;
  }

  WebDriver driver;

  public ChromeBrowser() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver(getChromeOptions());
    driver.manage().window().setSize(new Dimension(1920, 1080));
  }

  public void openGoogle() {
    driver.get("https://www.google.com/");
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void closeChrome() {
    driver.close();
  }

  /**
   * Gets Chrome options and capabilities.
   *
   * @return ChromeOptions instance.
   */
  private ChromeOptions getChromeOptions() {
    ChromeOptions chromeOptions = new ChromeOptions();
    // [MV] Passing the disable-infobars ChromeOption to the WebDriver, prevents Chrome from
    // displaying this notification.
    chromeOptions.addArguments("disable-infobars");
    addArguments(chromeOptions);
    chromeOptions.setExperimentalOption("prefs", getChromePreferences());

    DesiredCapabilities capability = new DesiredCapabilities();
    capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    return chromeOptions;
  }

  /**
   * Adds the ChromeOptions arguments for the current OS.
   *
   * @param options the Chrome Options.
   */
  private void addArguments(final ChromeOptions options) {
    options.addArguments("--remote-allow-origins=*");
    if (System.getProperty("os.name").contains("Windows")) {
      options.addArguments("disable-popup-blocking");
      options.addArguments("disable-out-of-process-pdf");
    } else {
      options.addArguments("--headless=new");
      options.addArguments("--disable-gpu");
      options.addArguments("--no-sandbox");
      options.addArguments("--start-maximized");
      options.addArguments("--window-size=1920,1080");
      options.addArguments("--allow-insecure-localhost");
      options.addArguments("--disable-dev-shm-usage");
    }
  }

  /**
   * Gets Chrome preferences.
   *
   * @return Map that contains Chrome preferences.
   */
  private Map<String, Object> getChromePreferences() {
    HashMap<String, Object> chromePref = new HashMap<>();
    // [MV] Sets Location to store files after downloading.
//    chromePref.put("download.default_directory", getDownloadPathAndInitialize());
    // [MV] Boolean to ask the user to download a file (true) or download automatically (false).
    chromePref.put("download.prompt_for_download", false);
    chromePref.put("profile.default_content_settings.popups", 0);
    // [MV] Sets Preference to not open the Pdf files.
    chromePref.put("plugins.always_open_pdf_externally", true);
    return chromePref;
  }
}
