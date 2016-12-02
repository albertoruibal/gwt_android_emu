/**
 * FILE GENERATED AUTOMATICALLY BY GWT_ANDROID_EMU'S GenerateResources: DO NOT EDIT MANUALLY
 */
package android.demo.res;

import android.view.Menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;

import android.demo.R;

public class Resources extends android.content.res.Resources {

	public static final Strings strings = GWT.create(Strings.class);
	public static final Arrays arrays = GWT.create(Arrays.class);
	public static final Layouts layouts = new Layouts();

	public String getIdAsString(int id) {
		switch (id) {
			case R.id.action1:
				return "action1";
			case R.id.menu1:
				return "menu1";
			case R.id.menu2:
				return "menu2";
			case R.id.menu_launch_fragment:
				return "menu_launch_fragment";
			case R.id.Fragment:
				return "Fragment";
			case R.id.AlertButton:
				return "AlertButton";
			case R.id.ToastButton:
				return "ToastButton";
			case R.id.HandlerButton:
				return "HandlerButton";
			case R.id.ActivityButton:
				return "ActivityButton";
			case R.id.SnackBarButton:
				return "SnackBarButton";
		}
		return super.getIdAsString(id);
	}
	public String getString(int id) {
		switch (id) {
			case R.string.activity1:
				return strings.activity1();
			case R.string.hello:
				return strings.hello();
			case R.string.action1:
				return strings.action1();
			case R.string.menu1:
				return strings.menu1();
			case R.string.menu2:
				return strings.menu2();
			case R.string.alert_dialog:
				return strings.alert_dialog();
			case R.string.dialog_title:
				return strings.dialog_title();
			case R.string.dialog_message:
				return strings.dialog_message();
			case R.string.dialog_yes:
				return strings.dialog_yes();
			case R.string.dialog_no:
				return strings.dialog_no();
			case R.string.toast:
				return strings.toast();
			case R.string.toast_text:
				return strings.toast_text();
			case R.string.handler:
				return strings.handler();
			case R.string.handler_message_received:
				return strings.handler_message_received();
			case R.string.activity:
				return strings.activity();
			case R.string.demo_fragment:
				return strings.demo_fragment();
			case R.string.demo_fragment2:
				return strings.demo_fragment2();
			case R.string.menu_launch_fragment:
				return strings.menu_launch_fragment();
			case R.string.snackbar:
				return strings.snackbar();
			case R.string.snackbar_text:
				return strings.snackbar_text();
			case R.string.snackbar_action:
				return strings.snackbar_action();
		}
		return super.getString(id);
	}
	public String[] getStringArray(int id) {
		switch (id) {
			case R.array.array1:
				return arrays.array1();
		}
		return super.getStringArray(id);
	}
	public Menu getMenu(int id) {
		switch (id) {
			case R.menu.demo_menu:
				return Menus.demo_menu();
			case R.menu.fragment_menu:
				return Menus.fragment_menu();
		}
		return super.getMenu(id);
	}
	public int getColor(int id) {
		switch (id) {
		}
		return super.getColor(id);
	}
	public String getDrawable(int id) {
		switch (id) {
			case R.drawable.ic_add:
				return "ic_add.svg";
			case R.drawable.icon:
				return "icon.png";
		}
		return super.getDrawable(id);
	}
	public Widget getLayout(int id) {
		switch (id) {
			case R.layout.main:
				return layouts.main();
			case R.layout.demo_fragment_activity:
				return layouts.demo_fragment_activity();
			case R.layout.demo_fragment:
				return layouts.demo_fragment();
			case R.layout.demo_fragment2:
				return layouts.demo_fragment2();
		}
		return super.getLayout(id);
	}
}
