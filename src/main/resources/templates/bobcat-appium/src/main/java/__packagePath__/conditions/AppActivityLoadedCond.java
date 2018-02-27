package @packageName@.conditions;

import com.cognifide.qa.bb.loadable.annotation.LoadableComponent;
import com.cognifide.qa.bb.loadable.condition.LoadableComponentCondition;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppActivityLoadedCond implements LoadableComponentCondition {

  @Inject
  private BobcatWait wait;

  public boolean check(Object subject, LoadableComponent data) {
    By locator = By.tagName("body");
    wait.withTimeout(data.timeout()).until(
        ExpectedConditions.presenceOfElementLocated(locator), data.delay());
    return true;
  }
}
