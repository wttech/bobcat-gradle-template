package @packageName@.pageobjects;

import com.cognifide.qa.bb.qualifier.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class MainActivity {

  @FindBy(id = "message")
  private WebElement message;

  @FindBy(id = "text_input")
  private WebElement textInput;

  @FindBy(id = "changeTextBtn")
  private WebElement changeTextButton;

  @FindBy(id = "submitBtn")
  private WebElement submitButton;


  public String getMessage() {
    return message.getText();
  }

  public void changeMessage(String newMessage) {
    textInput.sendKeys(newMessage);
    changeTextButton.click();
  }

  public void submitMessage(String newMessage) {
    textInput.sendKeys(newMessage);
    submit();
  }

  private void submit() {
    submitButton.click();
  }

}
