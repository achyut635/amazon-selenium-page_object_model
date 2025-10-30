package tests;

import base.DriverFactory;
import org.testng.annotations.*;
import io.qameta.allure.*;
import pages.*;

public class ProductFlowTest {
  @BeforeClass
  public void setUp() {
    // Use same driver from DriverFactory for simplicity in this example
    if (DriverFactory.getDriver() == null) {
      DriverFactory.initDriver(false);
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    DriverFactory.quitDriver();
  }

  @Test(groups = {"regression", "product"})
  @Story("Add to cart visibility")
  @Description("Searches for an item and navigates to product page to verify key elements are present.")
  public void verifyProductDetailsVisible() {
    AmazonHomePage home = new AmazonHomePage(DriverFactory.getDriver());
    home.search("wireless mouse");

    AmazonSearchResultsPage results = new AmazonSearchResultsPage(DriverFactory.getDriver());
    results.waitForVisible(results.firstResultTitle);
    results.openFirstResult();

    AmazonProductPage product = new AmazonProductPage(DriverFactory.getDriver());
    product.waitForVisible(product.productTitle);
    assert product.text(product.productTitle).length() > 0;
  }
}
