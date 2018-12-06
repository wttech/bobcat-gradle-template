package @packageName@.pageobjects;

import com.cognifide.qa.bb.page.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class WikipediaPage extends Page<WikipediaPage> {

  @Inject
  private WebDriver webDriver;

  @FindBy(id = "p-search")
  private SearchComponent searchComponent;

  public SearchComponent getSearchComponent() {
    return searchComponent;
  }

}
