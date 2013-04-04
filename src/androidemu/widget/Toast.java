package androidemu.widget;

import androidemu.content.Context;
import androidemu.view.Gravity;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class Toast {

	public final static int LENGTH_LONG = 1;
	public final static int LENGTH_SHORT = 0;

	String message;
	int gravity;
	int duration;

	public static Toast makeText(Context context, String message, int duration) {
		Toast toast = new Toast();
		toast.setMessage(message);
		toast.setDuration(duration);
		return toast;
	}

	public void show() {
		final PopupPanel panel = new PopupPanel();

		Label label = new Label(message);
		panel.setWidget(label);
		panel.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
			public void setPosition(int offsetWidth, int offsetHeight) {
				int left = (Window.getClientWidth() - offsetWidth) / 2;
				int top = 0;
				switch (gravity) {
					case Gravity.TOP:
						top = (Window.getClientHeight() - offsetHeight) / 10;
					case Gravity.CENTER:
						top = (Window.getClientHeight() - offsetHeight) / 2;
					break;
				}
				panel.setPopupPosition(left, top);
			}
		});

		// Create a new timer that calls Window.alert().
		Timer t = new Timer() {
			public void run() {
				panel.hide();
			}
		};

		// Schedule the timer to run once in 5 seconds.
		t.schedule(3000);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity, int xOffset, int yOffset) {
		this.gravity = gravity;
	}
}
