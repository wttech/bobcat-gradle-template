package @packageName@.pageobjects;

import com.cognifide.qa.bb.page.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.wait.BobcatWait;
import com.google.inject.Inject;

@PageObject
public class WikipediaPage extends Page<WikipediaPage> {

  @Inject
  private WebDriver webDriver;

  @Inject
  private BobcatWait bobcatWait;

  @FindBy(css = ".search-overlay")
  private SearchOverlayComponent searchOverlayComponent;

  @FindBy(id = "p-search")
  private SearchComponent searchComponent;

  @FindBy(id = "searchIcon")
  private WebElement openSearchOverlayButton;

  public WikipediaPage openSearchOverlay() {
    bobcatWait.until(ExpectedConditions.elementToBeClickable(openSearchOverlayButton));
    openSearchOverlayButton.click();
    return this;
  }

  public SearchComponent getSearchComponent() {
    return searchComponent;
  }

  public SearchOverlayComponent getSearchOverlayComponent() {
    return searchOverlayComponent;
  }

}
