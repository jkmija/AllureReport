package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxBrowser {
  WebDriver driver;
  public FirefoxBrowser(){
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver(getFirefoxOptions());
    driver.manage().window().setSize(new Dimension(1920,1080));
  }

  public void openGoogle()
  {
    driver.get("https://www.google.com/");
  }

  public String getTitle(){
    return driver.getTitle();
  }

  public void closeChrome(){
    driver.close();
  }

  /**
   * Gets Firefox options.
   *
   * @return FirefoxOptions instance.
   */
  private FirefoxOptions getFirefoxOptions() {
    // [MV] Creates FireFox Option object.
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions
        // [MV] Sets Location to store files after downloading.
//        .addPreference("browser.download.dir", getDownloadPathAndInitialize())
        .addPreference("browser.download.folderList", 2)
        // [MV] Sets Preference to not show file download confirmation dialogue using MIME types
        // Of different file extension types.
        .addPreference("browser.download.manager.showWhenStarting", false)
        .addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf")
        // [MV] Sets Preference to not open the Pdf files.
        .addPreference("pdfjs.disabled", true);
//    firefoxOptions.setHeadless(true);
//    firefoxOptions.addArguments("--headless");
    firefoxOptions.addArguments("--width=1920");
    firefoxOptions.addArguments("--height=1080");
//    firefoxOptions.addPreference("layout.css.devPixelsPerPx", "0.65");
    return firefoxOptions;
  }
}
