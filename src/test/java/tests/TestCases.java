package tests;

import io.qameta.allure.*;

import base.DriverFactory;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;
import pages.AmazonProductPage;
import pages.SignInPage;
import pages.CartPage;

@Listeners({base.AllureTestListener.class})
@Epic("Amazon")
@Feature("Shopping")
public class TestCases {
  private WebDriver driver;

  @BeforeClass
  public void setUp(@Optional("false") @org.testng.annotations.Parameters({"headed"}) String headed) {
    DriverFactory.initDriver(Boolean.parseBoolean(headed));
    driver = DriverFactory.getDriver();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    DriverFactory.quitDriver();
  }

  @Test(groups = {"smoke", "regression"})
  @Story("Search and view product")
  @Owner("QA")
  @Description("Searches for a product and opens the first result, then verifies product page loads.")
  public void searchAndOpenFirstResult() {
    AmazonHomePage home = new AmazonHomePage(driver);
    home.search("mechanical keyboard");

    AmazonSearchResultsPage results = new AmazonSearchResultsPage(driver);
    results.waitForVisible(results.firstResultTitle);
    System.out.println("First result: " + results.text(results.firstResultTitle));

    results.openFirstResult();
    AmazonProductPage product = new AmazonProductPage(driver);
    product.waitForVisible(product.productTitle);
    System.out.println("Product: " + product.text(product.productTitle));
  }

  @Test(groups = {"smoke"})
  @Story("Auth and Cart visibility")
  @Owner("QA")
  @Description("Navigates to Sign In page and Cart page to demonstrate element references and Allure attachments.")
  public void signInAndCartScaffolding() {
    SignInPage signin = new SignInPage(driver);
    signin.gotoPath("/ap/signin");
    signin.waitForVisible(signin.emailInput);

    CartPage cart = new CartPage(driver);
    cart.open();
    cart.waitForVisible(cart.cartSubTotalLabel);
    System.out.println("Cart subtotal label: " + cart.text(cart.cartSubTotalLabel));
  }
}
