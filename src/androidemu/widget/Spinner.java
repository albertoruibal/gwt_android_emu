package androidemu.widget;

import androidemu.view.View;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SelectElement;

public class Spinner extends View {

	public Spinner(Element element) {
		super(element);
	}

	public void setSelection(int index) {
		SelectElement.as(element).setSelectedIndex(index);
	}

	public int getSelectedItemPosition() {
		return SelectElement.as(element).getSelectedIndex();
	}

}
