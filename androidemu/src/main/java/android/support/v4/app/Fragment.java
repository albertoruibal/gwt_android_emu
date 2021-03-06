package android.support.v4.app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment {
	static final String TAG = "Fragment";

	Bundle args;
	FragmentActivity mActivity;
	int status, targetStatus;
	int containerViewId;
	String tag;
	ViewGroup container;
	View view;
	boolean visible = true;
	boolean hasMenu = true;

	ArrayList<Fragment> childFragments = new ArrayList<Fragment>();

	public void setArguments(Bundle args) {
		this.args = args;
	}

	public Bundle getArguments() {
		return args;
	}

	public FragmentActivity getActivity() {
		return mActivity;
	}

	public void onCreate(Bundle savedInstanceState) {
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return null;
	}

	public void onActivityCreated(Bundle savedInstanceState) {

	}

	public void onResume() {
	}

	public void onPause() {
	}

	public void onDestroy() {
	}

	public void setHasOptionsMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}

	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
	}

	public boolean isVisible() {
		return visible;
	}

	/**
	 * Call {@link Activity#startActivity(Intent)} on the fragment's
	 * containing Activity.
	 */
	public void startActivity(Intent intent) {
		if (mActivity == null) {
			throw new IllegalStateException("Fragment " + this + " not attached to Activity");
		}
		mActivity.startActivityFromFragment(this, intent, -1);
	}

	/**
	 * Return <code>getActivity().getResources()</code>.
	 */
	final public Resources getResources() {
		if (mActivity == null) {
			throw new IllegalStateException("Fragment " + this + " not attached to Activity");
		}
		return mActivity.getResources();
	}

	final public String getString(int resId) {
		if (mActivity == null) {
			throw new IllegalStateException("Fragment " + this + " not attached to Activity");
		}
		return mActivity.getString(resId);
	}
}