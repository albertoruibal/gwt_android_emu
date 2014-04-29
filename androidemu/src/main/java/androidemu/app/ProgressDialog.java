package androidemu.app;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import androidemu.Res;
import androidemu.content.Context;
import androidemu.content.DialogInterface;

public class ProgressDialog extends Dialog implements DialogInterface {

	private SimplePanel titleLabelContainer, messageLabelContainer;
	private Label titleLabel, messageLabel;

	public static ProgressDialog show(Context context, String title, String message, boolean indeterminate) {
		return new ProgressDialog(title, message, false);
	}

	public static ProgressDialog show(Context context, String title, String message, boolean indeterminate, boolean cancelable) {
		return new ProgressDialog(title, message, cancelable);
	}

	public ProgressDialog(String title, String message, boolean cancelable) {
		super(cancelable);

		VerticalPanel vp = new VerticalPanel();

		titleLabelContainer = new SimplePanel();
		messageLabelContainer = new SimplePanel();

		vp.add(titleLabelContainer);
		vp.add(messageLabelContainer);

		setTitle(title);
		setMessage(message);

		popupPanel.add(vp);
	}

	public void setTitle(String title) {
		if (titleLabel == null && title != null && !"".equals(title)) {
			titleLabel = new Label();
			titleLabel.setStyleName(Res.R.style().dialogTitle());
			titleLabelContainer.add(titleLabel);
		}
		if (titleLabel != null) {
			titleLabel.setText(title);
		}
		if (popupPanel.isShowing()) {
			popupPanel.center();
		}
	}

	public void setMessage(String message) {
		if (messageLabel == null && message != null && !"".equals(message)) {
			messageLabel = new Label();
			messageLabel.setStyleName(Res.R.style().dialogMessage());
			messageLabelContainer.add(messageLabel);
		}
		if (messageLabel != null) {
			messageLabel.setText(message);
		}
		if (popupPanel.isShowing()) {
			popupPanel.center();
		}
	}
}