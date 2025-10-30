package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AmazonSearchResultsPage extends BasePage {
  public final By resultsContainer = By.cssSelector("div.s-main-slot.s-result-list");
  public final By resultItems = By.cssSelector("div.s-main-slot.s-result-list > div[data-component-type='s-search-result']");
  public final By firstResultTitle = By.cssSelector("div.s-main-slot.s-result-list > div[data-component-type='s-search-result']:nth-of-type(1) h2 a span");
  public final By firstResultLink = By.cssSelector("div.s-main-slot.s-result-list > div[data-component-type='s-search-result']:nth-of-type(1) h2 a");
  public final By firstResultPrice = By.cssSelector("div.s-main-slot.s-result-list > div[data-component-type='s-search-result']:nth-of-type(1) .a-price .a-offscreen");

  public final By sortDropdown = By.id("s-result-sort-select");
  public final By primeCheckbox = By.cssSelector("li[id^='p_85'] input[type='checkbox'], span.aok-inline-block[aria-label*='Prime']");
  public final By departmentSection = By.xpath("//h2[contains(., 'Department')]");
  public final By brandFilter = By.xpath("//h2[contains(., 'Brand')]");

  public final By paginationNext = By.cssSelector("a.s-pagination-next, .s-pagination-item.s-pagination-next");
  public final By paginationPrev = By.cssSelector("a.s-pagination-previous, .s-pagination-item.s-pagination-previous");

  public AmazonSearchResultsPage(WebDriver driver) {
    super(driver);
    if (driver == null) {
        throw new IllegalArgumentException("WebDriver instance cannot be null");
    }
  }

  public void openFirstResult() 
  { 
    click(firstResultLink); 
  }

  public List<WebElement> allItems()
   {
    return driver.findElements(resultItems); 
  }
}

// Example usage:
// AmazonSearchResultsPage searchPage = new AmazonSearchResultsPage(driver);
// List<WebElement> items = searchPage.allItems();
// System.out.println("Number of items found: " + items.size());
