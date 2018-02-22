package @packageName@.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;

@PageObject
public class DefinitionPage {

  @FindBy(id = "firstHeading")
  private WebElement heading;

  public String getHeading() {
    return heading.getText();
  }
}
