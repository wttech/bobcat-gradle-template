package @packageName@.pageobjects.summer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.aem.dialog.classic.field.AemDropdown;
import com.cognifide.qa.bb.aem.dialog.classic.field.AemTextField;
import com.cognifide.qa.bb.aem.qualifier.DialogField;
import com.cognifide.qa.bb.aem.ui.component.AemComponent;
import com.cognifide.qa.bb.aem.ui.AemDialog;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

/**
 * Another simple component example from Geometrixx page.
 */
@PageObject
@AemComponent(cssClassName = "section-header", group = "Geometrixx Media", name = "Section Header")
public class SectionHeaderComponent {

	/**
	 * Helper enum that represents values available in the "size" field of sectionHeader's dialog.
	 */
	public enum Size {
		LARGE("h2", "Large (h2)"), MEDIUM("h3", "Medium (h3)"), DECK("h5", "Deck (h5)");

		private String hxTagName;

		private String label;

		Size(String hxTagName, String label) {
			this.hxTagName = hxTagName;
			this.label = label;
		}

		public static Size getInstance(String hxTagName) {
			for (Size size : values()) {
				if (size.hxTagName.equals(hxTagName))
					return size;
			}
			return null;
		}

		public String getLabel() {
			return label;
		}
	}

	/**
	 * Dialog instance.
	 */
	@Inject
	private AemDialog aemDialog;

	/**
	 * Dialog field that contains text of the header.
	 */
	@DialogField(label = "Header Text")
	private AemTextField headerText;

	/**
	 * Dialog field that contains size of the header.
	 */
	@DialogField(label = "Header size")
	private AemDropdown headerSize;

	/**
	 * Text of the header taken directly from the page.
	 */
	@FindBy(xpath = "./*/span")
	private WebElement sectionText;

	/**
	 * HTML element with the size of the header, taken directly from the page.
	 */
	@FindBy(xpath = "./*")
	private WebElement hxTag;

	/**
	 * @return Dialog instance.
	 */
	public AemDialog getDialog() {
		return aemDialog;
	}

	/**
	 * @return Text of the header, taken directly from the page.
	 */
	public String getText() {
		return sectionText.getText();
	}

	/**
	 * @return Size of the header, taken directly from the page.
	 */
	public Size getSize() {
		return Size.getInstance(hxTag.getTagName());
	}

	/**
	 * @return Dialog field with text of the header.
	 */
	public AemTextField getHeaderText() {
		return headerText;
	}

	/**
	 * @return Dialog field with size of the header.
	 */
	public AemDropdown getHeaderSize() {
		return headerSize;
	}

}
