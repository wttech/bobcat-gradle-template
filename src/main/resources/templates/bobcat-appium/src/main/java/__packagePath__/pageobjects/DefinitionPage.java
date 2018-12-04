package @packageName@.pageobjects;

import java.util.Collections;

import com.cognifide.qa.bb.wait.BobcatWait;
import com.google.inject.Inject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.StaleElementReferenceException;

import com.cognifide.qa.bb.qualifier.PageObject;

import org.openqa.selenium.support.ui.ExpectedConditions;

@PageObject
public class DefinitionPage {

  @Inject
  private BobcatWait bobcatWait;

  @FindAll({
      @FindBy(id = "firstHeading"),
      @FindBy(id = "section_0")})
  private WebElement heading;

  public String getHeading() {
    bobcatWait
        .ignoring(Collections.singletonList(StaleElementReferenceException.class))
        .until(ExpectedConditions.visibilityOf(heading));
    return heading.getText();
  }
}
