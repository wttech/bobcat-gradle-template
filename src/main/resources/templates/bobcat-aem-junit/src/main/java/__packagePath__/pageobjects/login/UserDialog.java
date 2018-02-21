package @packageName@.pageobjects.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.CurrentScope;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * This PageObject represents the user dialog that appears after clicking user icon.
 * <p/>
 * You can leave it as it is in your test project.
 */
@PageObject
public class UserDialog {

	@FindBy(partialLinkText = "Sign Out")
	private WebElement logoutButton;

	@Inject
	@CurrentScope
	private WebElement currentWebElement;

	public UserDialog signOut() {
		logoutButton.click();
		return this;
	}
}
