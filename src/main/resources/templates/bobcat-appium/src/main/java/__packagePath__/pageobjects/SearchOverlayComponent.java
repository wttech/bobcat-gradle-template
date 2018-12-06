package @packageName@.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class SearchOverlayComponent {

  @Inject
  private WebDriver webDriver;

  @FindBy(css = "input[type=search]")
  private WebElement searchField;

  public void searchForQuery(String query) {
    searchField.sendKeys(query);
    searchField.sendKeys(Keys.ENTER);
  }
}
