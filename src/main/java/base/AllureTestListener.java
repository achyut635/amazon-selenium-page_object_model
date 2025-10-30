package base;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class AllureTestListener implements ITestListener, ISuiteListener {

  private WebDriver getDriver() {
    return DriverFactory.getDriver();
  }

  @Attachment(value = "Page Screenshot", type = "image/png")
  private byte[] takeScreenshot() {
    try {
      return ((TakesScreenshot) Objects.requireNonNull(getDriver())).getScreenshotAs(OutputType.BYTES);
    } catch (Exception e) {
      return new byte[0];
    }
  }

  @Attachment(value = "Page URL", type = "text/plain")
  private byte[] attachUrl() {
    try {
      String url = getDriver().getCurrentUrl();
      return url.getBytes(StandardCharsets.UTF_8);
    } catch (Exception e) {
      return "N/A".getBytes(StandardCharsets.UTF_8);
    }
  }

  @Override
  public void onTestFailure(ITestResult result) {
    attachUrl();
    takeScreenshot();
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    attachUrl();
  }

  // no-op other methods for brevity
}
