package @packageName@.pageobjects.feedback;

import com.cognifide.qa.bb.aem.dialog.classic.field.AemFieldset;
import com.cognifide.qa.bb.aem.qualifier.DialogField;
import com.cognifide.qa.bb.aem.ui.AemDialog;
import com.cognifide.qa.bb.aem.ui.menu.AemToolbar;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class StartFormComponent {

    @Inject
    private AemDialog aemDialog;

    @DialogField(xpath = ".//fieldset/legend/span[text()='Action Configuration']/../..")
    private AemFieldset fieldset;

    @Inject
    private AemToolbar toolbar;

    public AemDialog getDialog() {
        return aemDialog;
    }

    public AemFieldset getFieldset() {
        return fieldset;
    }

    public AemToolbar getToolbar() {
        return toolbar;
    }

}
