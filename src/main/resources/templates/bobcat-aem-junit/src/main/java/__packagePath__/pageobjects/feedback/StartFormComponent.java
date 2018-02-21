package @packageName@.pageobjects.feedback;

import com.cognifide.qa.bb.aem.dialog.classic.field.AemTextField;
import com.cognifide.qa.bb.aem.qualifier.DialogField;
import com.cognifide.qa.bb.aem.ui.AemDialog;
import com.cognifide.qa.bb.aem.ui.menu.AemToolbar;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;


/**
 * Example page component.
 * <p/>
 * You will write your own component class from scratch, following the template:
 * <ul>
 * <li>class will be annotated with PageObject annotation,
 * <li>class name will end with "Component" suffix,
 * <li>class will contain injected fields related to dialog: AemDialog and some DialogFields,
 * <li>class will contain getters for the dialog, the dialogFields and some webElements.
 * </ul>
 */
@PageObject
public class StartFormComponent {
	/**
	 * Most of the components have associated dialogs.
	 * <p/>
	 * To get access to the dialog associated with the component, inject an instance of AemDialog.
	 */
	@Inject
	private AemDialog aemDialog;

	/**
	 * You can access a single dialog field by creating a field with DialogField annotation.
	 */
	@DialogField(label = "Form Identifier")
	private AemTextField formIdentifier;

	/**
	 * Inject an instance of AemToolbar that will be used to configure your component in the test
	 */
	@Inject
	private AemToolbar toolbar;

	/**
	 * Getter for the dialog.
	 */
	public AemDialog getDialog() {
		return aemDialog;
	}

	/**
	 * Getter for the component.
	 */
	public AemTextField getFormIdentifier() {
		return formIdentifier;
	}

	/**
	 * Getter for the toolbar.
	 */
	public AemToolbar getToolbar() {
		return toolbar;
	}

}
