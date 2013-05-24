package androidemu.widget;

import androidemu.view.View;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;

public class EditText extends View {

	public EditText(Element element) {
		super(element);
	}

	public void setText(String text) {
		InputElement.as(element).setValue(text);
	}

	public String getText() {
		return InputElement.as(element).getValue();
	}

	public void setEnabled(boolean enabled) {
		if (enabled) {
			element.removeAttribute("disabled");
		} else {
			element.setAttribute("disabled", "disabled");
		}
	}
}