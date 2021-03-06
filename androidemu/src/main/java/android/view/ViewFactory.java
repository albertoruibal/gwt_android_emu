package android.view;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gwt.dom.client.Element;
import com.viewpagerindicator.TitlePageIndicator;

public class ViewFactory {

	static final String TAG = "ViewFactory";

	/**
	 * From a DOM element creates the right Android-emulated Widget
	 *
	 * @param element
	 * @return
	 */
	public static View createViewFromElement(Element element) {
		if (element.getNodeName() == "LABEL") {
			return new TextView(element);
		} else if (element.getNodeName() == "DIV") {
			String className = element.getAttribute("class").toUpperCase();
			if (className != null) {
				if (className.contains("LISTVIEW")) {
					return new ListView(element);
				} else if (className.contains("RECYCLERVIEW")) {
					return new RecyclerView(element);
				} else if (className.contains("SCROLLVIEW")) {
					return new ScrollView(element);
				} else if (className.contains("LINEARLAYOUT")) {
					return new LinearLayout(element);
				} else if (className.contains("DRAWERLAYOUT")) {
					return new DrawerLayout(element);
				} else if (className.contains("VIEWPAGER")) {
					return new ViewPager(element);
				} else if (className.contains("TITLEPAGEINDICATOR")) {
					return new TitlePageIndicator(element);
				}
				// DIV fallbacks to TextView
				return new TextView(element);
			}
		} else if (element.getNodeName() == "BUTTON") {
			return new Button(element);
		} else if (element.getNodeName() == "TEXTAREA") {
			return new EditText(element, true);
		} else if (element.getNodeName() == "INPUT") {
			String type = element.getAttribute("type").toUpperCase();
			if (type.equals("TEXT")) {
				return new EditText(element, false);
			} else if (type.equals("NUMBER")) {
				return new EditText(element, false);
			} else if (type.equals("PASSWORD")) {
				return new EditText(element, false);
			} else if (type.equals("BUTTON")) {
				return new Button(element);
			} else if (type.equals("RADIO")) {
				return new RadioButton(element);
			} else if (type.equals("CHECKBOX")) {
				return new CheckBox(element);
			} else if (type.equals("IMAGE")) {
				return new ImageButton(element);
			} else {
				Log.d(TAG, "Not found an specific view for input type " + type);
			}
		} else if (element.getNodeName() == "SELECT") {
			return new Spinner(element);
		} else if (element.getNodeName() == "IMG") {
			return new ImageView(element);
		} else {
			Log.d(TAG, "Not found an specific view: " + element.getNodeName());
		}

		return new View(element);
	}

	public static Element getElementById(Element element, String id) {
		if (id.equals(element.getId())) {
			return element;
		}
		Element child = element.getFirstChildElement();
		if (child != null) {
			Element out = getElementById(child, id);
			if (out != null) {
				return out;
			}
		}
		Element next = element.getNextSiblingElement();
		if (next != null) {
			Element out = getElementById(next, id);
			if (out != null) {
				return out;
			}
		}
		return null;
	}

	public static View findViewById(Element element, String id) {
		Element elementFound = ViewFactory.getElementById(element, id);

		if (elementFound == null) {
			Log.e(TAG, "View not found: " + id);
			return null;
		}
		return ViewFactory.createViewFromElement(elementFound);
	}
}