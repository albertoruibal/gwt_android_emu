package androidemu.app;

import androidemu.Res;
import androidemu.content.ComponentName;
import androidemu.content.Context;
import androidemu.content.Intent;
import androidemu.os.Bundle;
import androidemu.view.Menu;
import androidemu.view.MenuItem;
import androidemu.view.View;
import androidemu.view.ViewFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Activity extends Context implements EntryPoint {

	public static final String TAG = "Activity";

	public static final int RESULT_CANCELED = 0;
	public static final int RESULT_FIRST_USER = 1;
	public static final int RESULT_OK = -1;

	public static final String ACTIVITY_ID = "activity";

	int status = 0;
	int targetStatus = 0;

	String title;
	Menu menu;
	Widget contentPanel;
	private PopupPanel menuPanel;

	Intent intent;
	Integer requestCode;
	int resultCode = RESULT_OK;
	Intent resultData;

	// Data when we return from another activity
	Integer returnRequestCode;
	int returnResultCode;
	Intent returnResultData;

	public void onModuleLoad() {
		Res.R.style().ensureInjected();

		ActivityManager.setup();
		startActivity(new Intent(this, this));
	}

	protected void onCreate(Bundle savedInstanceState) {

	}

	protected void onResume() {
		if (contentPanel != null) {
			contentPanel.setVisible(true);
		}
	}

	protected void onPause() {
		if (contentPanel != null) {
			contentPanel.setVisible(false);
		}
	}

	protected void onDestroy() {
		if (contentPanel != null) {
			RootPanel.get(ACTIVITY_ID).remove(contentPanel);
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return true;
	}

	void createMenu() {
		if (menu == null) {
			menu = new Menu();
			onCreateOptionsMenu(menu);

			if (menu.menuItems.size() > 0) {
				menuPanel = new PopupPanel();
				menuPanel.setStyleName(Res.R.style().dialog());
				FlowPanel fp = new FlowPanel();

				for (final MenuItem item : menu.menuItems) {
					Button b = new Button();
					b.setText(item.getTitle());
					b.setStyleName(Res.R.style().menuItem());
					b.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							hideMenu();
							onOptionsItemSelected(item);
						}
					});
					fp.add(b);
				}
				menuPanel.setWidget(fp);
			}
		}
	}

	void hideMenu() {
		if (menuPanel != null && menuPanel.isShowing()) {
			menuPanel.hide();
		}
	}

	/**
	 * Used only by the system menu button
	 */
	void toggleOptionsMenu(View view) {
		if (menuPanel != null) {
			if (!menuPanel.isShowing()) {
				menuPanel.setAutoHideEnabled(false);
				menuPanel.setPopupPosition(view.getLeft(), view.getTop() + view.getHeight());
				menuPanel.show();
			} else {
				menuPanel.hide();
			}
		}
	}

	public void openOptionsMenu() {
		if (menuPanel != null) {
			menuPanel.setAutoHideEnabled(true);
			menuPanel.center();
			menuPanel.show();
		}
	}

	public void closeOptionsMenu() {
		if (menuPanel != null) {
			menuPanel.hide();
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Context getApplicationContext() {
		// not very correct, but it's a context and at the moment we do not
		// differentiate among contexts
		return this;
	}

	public void finish() {
		ActivityManager.finish(this);
	}

	public void setContentView(TextResource content) {
		contentPanel = new HTMLPanel(content.getText());
		RootPanel.get(ACTIVITY_ID).add(contentPanel);
	}

	public void setContentView(Widget htmlPanel) {
		contentPanel = htmlPanel;
		RootPanel.get(ACTIVITY_ID).add(contentPanel);
	}

	protected void onSaveInstanceState(Bundle outState) {
	}

	public void startActivityForResult(Intent intent, int requestCode) {
		ActivityManager.startActivity(intent, requestCode);
	}

	public void setResult(int resultCode, Intent resultData) {
		this.resultCode = resultCode;
		this.resultData = resultData;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	}

	public void onBackPressed() {
	}

	public View findViewById(String id) {
		return ViewFactory.findViewById(contentPanel.getElement(), id);
	}

	public Intent getIntent() {
		return intent;
	}
}