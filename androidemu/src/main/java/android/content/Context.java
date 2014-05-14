package android.content;

import android.app.ActivityManager;
import android.app.Application;
import android.content.res.Resources;

public class Context {

	static Application application = new Application();
	Resources resources = new Resources();

	public Resources getResources() {
		return resources;
	}

	public String getString(int in) {
		return Resources.getResourceResolver().getString(in);
	}

	public void startActivity(Intent intent) {
		ActivityManager.startActivity(intent, null);
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		Context.application = application;
	}

	public String getPackageName() {
		return ""; // TODO
	}
}