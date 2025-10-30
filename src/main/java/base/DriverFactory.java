package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverFactory {
  private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

  public static void initDriver(boolean headed) {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    if (!headed) options.addArguments("--headless=new");
    options.addArguments("--window-size=1366,820", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
    tlDriver.set(new ChromeDriver(options));
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
    getDriver().get("https://www.amazon.com/");
  }

  public static WebDriver getDriver() { return tlDriver.get(); }

  public static void quitDriver() {
    if (getDriver() != null) {
      getDriver().quit();
      tlDriver.remove();
    }
  }
}
