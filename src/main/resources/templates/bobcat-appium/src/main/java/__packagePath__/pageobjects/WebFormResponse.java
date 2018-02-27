package @packageName@.pageobjects;

import com.cognifide.qa.bb.qualifier.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class WebFormResponse {

  @FindBy(id = "response")
  private WebElement responseMessage;

  public String getResponseMessage() {
    return responseMessage.getText();
  }
}
