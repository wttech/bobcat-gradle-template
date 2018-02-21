package @packageName@.feedback;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import @packageName@.GuiceModule;
import @packageName@.pageobjects.feedback.FeedbackPage;
import @packageName@.pageobjects.feedback.StartFormComponent;
import @packageName@.pageobjects.login.LoginPage;
import @packageName@.pageobjects.login.ProjectsScreen;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cognifide.qa.bb.frame.FrameSwitcher;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.google.inject.Inject;

/**
 * Simple test for presenting alternative way to open a dialog.
 * <p/>
 * For some components dialog may be opened only by clicking edit button on toolbar instead of
 * double click in component area.
 */
@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class StartFormComponentTest {

	@Inject
	private FeedbackPage feedBackPage;

	@Inject
	private LoginPage loginPage;

	@Inject
	private WebDriver webDriver;
	
	@Inject
	private FrameSwitcher frameSwitcher;

	private StartFormComponent startFormComponent;

	/**
	 * Check if FeedbackPage page has been opened.
	 */
	private void openPageToTest() {
		feedBackPage.open();
		assertTrue("Page is not opened", feedBackPage.isDisplayed());
	}

	/**
	 * Check if log in has been succeeded.
	 */
	private void logIn() {
		ProjectsScreen projectsScreen = loginPage.loginAsAuthor();
		assertTrue("Login has not been succeeded", projectsScreen.isDisplayed());
	}

	@Before
	public void before() {
		logIn();
		openPageToTest();
		startFormComponent = feedBackPage.getStartFormComponent();
	}

	/**
	 * After all tests sleep 1 second to let webDriver close the window.
	 */
	@AfterClass()
	public static void afterClass() {
		BobcatWait.sleep(1);
	}

	/**
	 * Open dialog using toolbar, change tab type text into textfield, close dialog, refresh the page. After
	 * that form element with typed id should appears on the page.
	 */
	@Test
	public void testChangeIdOfFormElement() {
		String randomId = RandomStringUtils.randomAlphabetic(20);
		startFormComponent.getToolbar().edit();
		startFormComponent.getDialog().clickTab("Advanced");
		startFormComponent.getFormIdentifier().clear().type(randomId);
		startFormComponent.getDialog().ok();
		webDriver.navigate().refresh();
		assertTrue("Page is not displayed", feedBackPage.isDisplayed());
		try {
			frameSwitcher.switchTo("$cq");
			webDriver.findElement(By.id(randomId));
		} catch (NoSuchElementException e) {
			fail("Element not found");
		} finally {
			frameSwitcher.switchBack();
		}
	}
}
