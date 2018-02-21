package @packageName@.pageobjects.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.aem.page.AuthorPage;
import com.cognifide.qa.bb.qualifier.PageObject;

/**
 * This component represents AEM projects page. You can leave this class as it is in your test project.
 */
@PageObject
public class ProjectsScreen extends AuthorPage {

	@FindBy(css = "a.user.icon-user, a.endor-BlackBar-item.endor-UserProfile")
	private WebElement userIcon;

	@FindBy(css = "#user_dialog, #granite-user-properties")
	private UserDialog userDialog;

	public UserDialog openUserDialog() {
		userIcon.click();
		return userDialog;
	}

	@Override
	public String getContentPath() {
		return "/projects.html";
	}

	@Override
	public String getPageTitle() {
		return "AEM Projects";
	}
}
