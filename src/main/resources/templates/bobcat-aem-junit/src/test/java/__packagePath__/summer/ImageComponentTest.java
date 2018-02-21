package @packageName@.summer;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cognifide.qa.bb.aem.ui.AemContentFinder;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.TestRunner;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import @packageName@.GuiceModule;
import @packageName@.pageobjects.login.LoginPage;
import @packageName@.pageobjects.summer.ImageComponent;
import @packageName@.pageobjects.summer.SummerBlockbusterHitsPage;
import com.google.inject.Inject;

/**
 * Test for presenting drag and drop functionality using content finder and image component.
 */
@RunWith(TestRunner.class)
@Modules(GuiceModule.class)
public class ImageComponentTest {

	@Inject
	private LoginPage loginPage;

	@Inject
	private SummerBlockbusterHitsPage page;

	@Inject
	private AemContentFinder contentFinder;

	private ImageComponent imageComponent;

	/**
	 * Before each test log in, open page {@link SummerBlockbusterHitsPage} to test and get
	 * {@link ImageComponent}.
	 */
	@Before
	public void before() {
		logIn();
		openPageToTest();
		imageComponent = page.getImageComponent();
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
	public void insertImageTest() {
		contentFinder.clickTab("Images");
		contentFinder.search("");
		List<String> results = contentFinder.getResults();
		if (results.size() > 0) {
			imageComponent.getDialog().open();
			imageComponent.insert(contentFinder.getElementByIndex(0));
			imageComponent.getDialog().ok();
			assertTrue("Image not found", results.get(0).contains(imageComponent.getImgAttribute("title")));
		}

	}
}
