package @packageName@.pageobjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognifide.qa.bb.constants.Timeouts;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.utils.PageObjectInjector;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * This class represents AEM login page.
 * <p/>
 * You can leave it as it is in your test project.
 */
@PageObject
public class LoginPage {

	private static final String PAGE_TITLE = "AEM Sign In";

	private static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

	/**
	 * WebDriver instance needed to open the page.
	 */
	@Inject
	private WebDriver webDriver;

	/**
	 * We'll use this injector to tell Bobcat to create an object within manually defined frame.
	 */
	@Inject
	private PageObjectInjector injector;

	/**
	 * We'll be waiting for some WebElements to appear on the page, so we need an instance of BobcatWait.
	 */
	@Inject
	private BobcatWait bobcatWait;

	/**
	 * Login to be used in the author instance. Bobcat will inject value taken from the author.login property.
	 */
	@Inject
	@Named("author.login")
	private String authorLogin;

	/**
	 * Password to be used in the author instance. Bobcat will inject value taken from the author.password property.
	 */
	@Inject
	@Named("author.password")
	private String authorPassword;

	/**
	 * URL of the author instance. Bobcat will inject value taken from the author.url property.
	 */
	@Inject
	@Named("author.url")
	private String authorUrl;

	@Inject
	@Named("page.title.timeout")
	private int pageTitleTimeout;

	/**
	 * LoginBox PageObject, looked up with FindBy annotation.
	 */
	@FindBy(id = "login-box")
	private LoginBox loginBox;

	@Inject
	private BobcatWait wait;

	/**
	 * @return Instance of the LoginBox associated with this page.
	 */
	public LoginBox getLoginBox() {
		return loginBox;
	}

	/**
	 * Opens the login page.
	 */
	public LoginPage openLoginPage() {
		webDriver.get(authorUrl);
		bobcatWait.withTimeout(Timeouts.MEDIUM).until(ExpectedConditions.visibilityOfElementLocated(By.id("login-box")));
		return this;
	}

	/**
	 * Tries to log in and produces welcoming ProjectsScreen.
	 */
	public ProjectsScreen loginAsAuthor() {
		openLoginPage();
		loginBox.enterLogin(authorLogin);
		bobcatWait.withTimeout(Timeouts.SMALL).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
				return webDriver.findElement(By.id("username")).getAttribute("value").equals(authorLogin);
			}
		});
		loginBox.enterPassword(authorPassword).clickSignIn();
		return injector.inject(ProjectsScreen.class, "/");
	}

	/**
	 * @return True if the login page is displayed. False otherwise.
	 */

	public boolean loginPageIsDisplayed() {
		try {
			wait
				.withTimeout(pageTitleTimeout)
				.until(ExpectedConditions.titleIs(PAGE_TITLE));
		} catch (TimeoutException te) {
			LOG.error("TimeoutException thrown when waiting for page title to appear. Expected title: "
					+ PAGE_TITLE, te);
			return false;
		}
		return true;
	}
}
