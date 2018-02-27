package @packageName@.steps;

import com.cognifide.qa.bb.aem.dialog.configurer.ConfigurationEntry;
import com.cognifide.qa.bb.aem.ui.menu.AemToolbar;
import com.cognifide.qa.bb.constants.Timeouts;
import com.cognifide.qa.bb.scenario.ScenarioContext;
import @packageName@.pageobjects.feedback.FeedbackPage;
import @packageName@.pageobjects.feedback.StartFormComponent;
import com.cognifide.qa.bb.aem.ui.AemDialog;
import com.cognifide.qa.bb.aem.dialog.configurer.ComponentConfigurerFactory;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.google.inject.Inject;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ScenarioScoped
public class AuthorPageSteps {

    @Inject
    private ScenarioContext scenarioContext;

    @Inject
    private ComponentConfigurerFactory componentConfigurerFactory;

    @Inject
    private FeedbackPage feedbackPage;

    @Inject
    private BobcatWait wait;

    private AemDialog aemDialog;

    @Then("^I have opened Feedback page$")
    public void I_have_opened_Feedback_page() {
        feedbackPage.open();
        scenarioContext.add("pageTitle", feedbackPage.getPageTitle());
        assertTrue("Feedback page is not displayed", feedbackPage.isDisplayed());
    }

    @And("^I edit start from component$")
    public void I_edit_start_from_component() {
        StartFormComponent startFormComponent = feedbackPage.getStartFormComponent();
        final AemToolbar toolbar = startFormComponent.getToolbar();
        aemDialog = startFormComponent.getDialog();

        // Selenium has a problem with clicking the toolbar on a slow PC. The function that hovers over
        // to the edit button triggers some markup changes as the cursor passes over components above
        // the startFormComponent and the click does not actually interact with the edit button.
        // Therefore we check if the operation succeeded and retry if necessary.
        wait.withTimeout(Timeouts.BIG).until(driver -> {
            toolbar.edit();
            return aemDialog.isVisible();
        });
    }

    @And("^my component configuration data is:$")
    public void my_component_configuration_data_is(List<ConfigurationEntry> config) {
        scenarioContext.add("config", config);
    }

    @SuppressWarnings("unchecked")
    @And("^I set the rest of the properties using my component configuration data$")
    public void I_set_the_rest_of_the_properties_using_my_component_configuration_data() {
        componentConfigurerFactory.create(aemDialog).configureDialog(
            scenarioContext.getList("config"));
    }

    @Then("^component is configured according to configuration data$")
    public void component_is_configured_according_to_configuration_data() {
        List<ConfigurationEntry> componentConfiguration = componentConfigurerFactory.create(aemDialog)
            .getDialogConfiguration(scenarioContext.getList("config"));
        for (int i = 0; i < componentConfiguration.size(); i++) {
            ConfigurationEntry entry = componentConfiguration.get(i);
            assertEquals("Incorrect configuration entry: " + entry, entry, scenarioContext.getList("config").get(i));
        }
    }
}
