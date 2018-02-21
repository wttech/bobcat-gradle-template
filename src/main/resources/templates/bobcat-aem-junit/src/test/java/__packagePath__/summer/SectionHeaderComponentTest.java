package @packageName@.summer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import @packageName@.GuiceModule;
import @packageName@.pageobjects.login.LoginPage;
import @packageName@.pageobjects.summer.SectionHeaderComponent;
import @packageName@.pageobjects.summer.SectionHeaderComponent.Size;
import @packageName@.pageobjects.summer.SummerBlockbusterHitsPage;
import com.google.inject.Inject;

/**
 * Basic test for component with textfield and dropdown list.
 */
@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class SectionHeaderComponentTest {

	@Inject
	private LoginPage loginPage;

	@Inject
	private SummerBlockbusterHitsPage page;

	private SectionHeaderComponent sectionHeaderComponent;

	/**
	 * Before each test log in, open page {@link SummerBlockbusterHitsPage} to test and get
	 * {@link SectionHeaderComponent}.
	 */
	@Before
	public void before() {
		logIn();
		openPageToTest();
		sectionHeaderComponent = page.getSectionHeader();
	}

	/**
	 * Check if SummerBlockbusterHits page has been opened.
	 */
	private void openPageToTest() {
		page.open();
		assertTrue("Page is not displayed", page.isDisplayed());
	}

	/**
	 * Check if log in has been succeeded.
	 */
	private void logIn() {
		assertTrue("Login page is not displayed", loginPage.loginAsAuthor().isDisplayed());
	}

	/**
	 * After all tests sleep 1 second to let webDriver close the window.
	 */
	@AfterClass()
	public static void afterClass() {
		BobcatWait.sleep(1);
	}

	@Test
	public void testTypeAndSize() {
		for (Size size : Size.values()) {
			typeTextAndSelectSize("My CharSequence " + size.getLabel(), size);
			assertEquals("Wrong text", "My CharSequence " + size.getLabel(), sectionHeaderComponent.getText());
			assertEquals("Wrong text size", size, sectionHeaderComponent.getSize());
		}
	}

	private void typeTextAndSelectSize(String textToType, Size size) {
		sectionHeaderComponent.getDialog().open();
		sectionHeaderComponent.getHeaderText().clear().type(textToType);
		sectionHeaderComponent.getHeaderSize().selectByText(size.getLabel());
		sectionHeaderComponent.getDialog().ok();
	}
}
