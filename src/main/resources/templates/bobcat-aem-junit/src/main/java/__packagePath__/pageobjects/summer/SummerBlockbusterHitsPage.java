package @packageName@.pageobjects.summer;

import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.aem.page.AuthorPage;
import com.cognifide.qa.bb.qualifier.Frame;
import com.cognifide.qa.bb.qualifier.PageObject;

/**
 * This class represents a page from Geometrixx project.
 * <p/>
 * Frame annotation determines default frame for all methods in this class.
 */
@PageObject
@Frame("$cq")
public class SummerBlockbusterHitsPage extends AuthorPage {

	private static final String PAGE_TITLE = "Summer Blockbuster Hits and Misses";

	private static final String URL = "/cf#/content/geometrixx-media/en/entertainment/summer-blockbuster-hits-and-misses.html";

	@FindBy(xpath = "//div[contains(@class, 'cq-element-article-content-par_47image')]")
	private ImageComponent imageComponent;

	@FindBy(className = "cq-element-right-panel-par_47section_95header")
	private SectionHeaderComponent sectionHeader;

	public ImageComponent getImageComponent() {
		return imageComponent;
	}

	public SectionHeaderComponent getSectionHeader() {
		return sectionHeader;
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
