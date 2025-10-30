package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  public void gotoPath(String path) { driver.navigate().to("https://www.amazon.com" + path); }

  public void waitForVisible(By locator) { wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); }

  public WebElement el(By locator) { return wait.until(ExpectedConditions.presenceOfElementLocated(locator)); }

  public void click(By locator) { wait.until(ExpectedConditions.elementToBeClickable(locator)).click(); }

  public void type(By locator, String text) {
    WebElement e = el(locator);
    e.clear(); e.sendKeys(text);
  }

  public String text(By locator) { return el(locator).getText(); }
}
