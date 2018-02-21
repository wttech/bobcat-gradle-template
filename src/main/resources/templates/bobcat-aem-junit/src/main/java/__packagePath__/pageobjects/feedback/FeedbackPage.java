package @packageName@.pageobjects.feedback;

import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.aem.page.AuthorPage;
import com.cognifide.qa.bb.qualifier.Frame;
import com.cognifide.qa.bb.qualifier.PageObject;


/**
 * This is an example class that represents a page from Geometrixx project.
 * <p/>
 * You will create a similar class for each of the pages that you test.
 * <p/>
 * Remember to put PageObject annotation on your page class.
 */
@PageObject
@Frame("$cq")
public class FeedbackPage extends AuthorPage {

	/**
	 * Replace value of this constant with relative address of your page.
	 */
	private static final String URL = "/cf#/content/geometrixx/en/toolbar/feedback.html";

	/**
	 * Replace value of this constant with the title of your page.
	 */
	private static final String PAGE_TITLE = "Feedback";

	/**
	 * Create a field for each page component that you want to test. Lookup each component with a FindBy.
	 */
	@FindBy(className = "cq-element-par_470001")
	private StartFormComponent startFormComponent;

	/**
	 * @return Instance of the component embedded in the page.
	 */
	public StartFormComponent getStartFormComponent() {
		return startFormComponent;
	}

	@Override
	public String getContentPath() {
		return URL;
	}

	@Override
	public String getPageTitle() {
		return PAGE_TITLE;
	}
}
