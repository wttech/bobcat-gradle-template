package @packageName@;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.loadable.annotation.LoadableComponent;
import @packageName@.conditions.AppActivityLoadedCond;
import @packageName@.guice.GuiceModule;
import @packageName@.pageobjects.MainActivity;
import @packageName@.pageobjects.WebFormResponse;
import com.google.inject.Inject;
import io.appium.java_client.MobileDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class EspressoAppTest {

  public static final String WEBVIEW_CONTEXT =
      "WEBVIEW_com.example.android.testing.espresso.web.BasicSample";

  public static final String TEST_MESSAGE = "Test message";

  @Inject
  private WebDriver driver;

  @Inject
  @LoadableComponent(condClass = AppActivityLoadedCond.class)
  private MainActivity mainActivity;

  @Inject
  @LoadableComponent(condClass = AppActivityLoadedCond.class)
  private WebFormResponse formResponse;

  @Before
  public void setUp() {
    ((MobileDriver) driver).context(WEBVIEW_CONTEXT);
  }

  @Test
  public void testMessageChange() {
    mainActivity.changeMessage(TEST_MESSAGE);
    assertThat(mainActivity.getMessage()).isEqualTo(TEST_MESSAGE);
  }

  @Test
  public void testSubmitMessage() {
    mainActivity.submitMessage(TEST_MESSAGE);
    assertThat(formResponse.getResponseMessage()).isEqualTo(TEST_MESSAGE.replaceAll(" ", "+"));
  }

}
