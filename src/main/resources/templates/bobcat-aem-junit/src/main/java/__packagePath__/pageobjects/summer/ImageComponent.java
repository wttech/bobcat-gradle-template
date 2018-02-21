package @packageName@.pageobjects.summer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.aem.dialog.classic.field.image.AemImage;
import com.cognifide.qa.bb.aem.qualifier.DialogField;
import com.cognifide.qa.bb.aem.ui.component.AemComponent;
import com.cognifide.qa.bb.aem.ui.AemDialog;
import com.cognifide.qa.bb.dragdrop.Draggable;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * Represents a single image component in the Gometrixx page.
 * <p/>
 * You can easily reuse this class, perhaps with a small modification, to create your own components.
 */
@PageObject
@AemComponent(cssClassName = "image", group = "General", name = "Image")
public class ImageComponent {
	/**
	 * Image component has a dialog.
	 */
	@Inject
	private AemDialog dialog;

	/**
	 * Dialog contains an image field.
	 */
	@DialogField(css = ".cq-smartfile-_46_47file")
	private AemImage image;

	/**
	 * It is possible to lookup the image that is associated with the image component.
	 */
	@FindBy(xpath = ".//img")
	private WebElement img;

	/**
	 * @return Dialog instance.
	 */
	public AemDialog getDialog() {
		return dialog;
	}

	/**
	 * Clears the image in the dialog.
	 */
	public void clear() {
		image.clear();
	}

	/**
	 * Drags the image from content finder to the image field in the dialog.
	 */
	public void insert(Draggable elementByName) {
		image.insert(elementByName);
	}

	/**
	 * Return the path of the image from the IMG element on the page.
	 */
	public String getImgAttribute(String attributeName) {
		return img.getAttribute(attributeName);
	}

}
