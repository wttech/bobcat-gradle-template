package @packageName@.pageobjects.feedback;

import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import com.cognifide.qa.bb.qualifier.Frame;
import com.cognifide.qa.bb.qualifier.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PageObject
@Frame("$cq")
public class FeedbackPage {

    private static final Logger LOG = LoggerFactory.getLogger(FeedbackPage.class);

    private static final String URL = "/cf#/content/geometrixx/en/toolbar/feedback.html";

    private static final String PAGE_TITLE = "Feedback";

    @Inject
    private WebDriver webDriver;

    @Inject
    @Named("page.title.timeout")
    private int pageTitleTimeout;

    @Inject
    @Named("author.url")
    private String authorUrl;

    @Inject
    private BobcatWait bobcatWait;

    @FindBy(css = ".cq-element-par_470001")
    private StartFormComponent startFormComponent;

    /**
     * @return Full URL of the page which means: domain plus "content path".
     */
    public String getFullUrl() {
        return authorUrl + URL;
    }

    /**
     * @return True if the page is displayed, false otherwise.
     * <p/>
     * Assumes that the page is displayed when title of the currently displayed page is the same as the title
     * stored in this object.
     */
    public boolean isDisplayed() {
        try {
            bobcatWait.withTimeout(pageTitleTimeout).until(ExpectedConditions.titleIs(getPageTitle()));
        } catch (TimeoutException te) {
            LOG.error("TimeoutException thrown when waiting for page title to appear. Expected title: "
                    + PAGE_TITLE, te);
            return false;
        }
        return true;
    }

    /**
     * Opens the page in a new browser window.
     */
    public void open() {
        webDriver.get(getFullUrl());
    }

    /**
     *
     * @return StartFormComponent
     */
    public StartFormComponent getStartFormComponent() {
        return startFormComponent;
    }

    /**
     *
     * @return Page title
     */
    public String getPageTitle() {
        return PAGE_TITLE;
    }
}
