package @packageName@.login;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import @packageName@.GuiceModule;
import @packageName@.pageobjects.login.LoginPage;
import com.google.inject.Inject;

/**
 * Test for presenting how to log in to the page.
 */
@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class AuthorizationTest {

	@Inject
	private LoginPage loginPage;

	@Test
	public void loginAsAuthorTest() {
		assertTrue("Login page is not displayed", loginPage.loginAsAuthor().isDisplayed());
	}

	/**
	 * After all tests sleep 1 second to let webDriver close the window
	 */
	@AfterClass()
	public static void afterClass() {
		BobcatWait.sleep(1);
	}

}
