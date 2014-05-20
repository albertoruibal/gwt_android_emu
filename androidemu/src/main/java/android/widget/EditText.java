package android.widget;

import android.content.res.Resources;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.TextAreaElement;

public class EditText extends TextView {

	boolean isTextArea = false;

	public EditText(Element element, boolean isTextArea) {
		super(element);
		this.isTextArea = isTextArea;
	}

	public void setText(int stringId) {
		setText(Resources.getResourceResolver().getString(stringId));
	}

	public void setText(String text) {
		if (isTextArea) {
			TextAreaElement.as(element).setValue(text);
		} else {
			InputElement.as(element).setValue(text);
		}
	}

	public String getText() {
		if (isTextArea) {
			return TextAreaElement.as(element).getValue();
		} else {
			return InputElement.as(element).getValue();
		}
	}
}
