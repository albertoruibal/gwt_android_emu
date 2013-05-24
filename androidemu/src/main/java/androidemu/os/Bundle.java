package androidemu.os;

import java.util.HashMap;

public class Bundle {

	HashMap<String, String> values = new HashMap<String, String>();

	public void put(String key, String value) {
		values.put(key, value);
	}

	public void putString(String key, String value) {
		values.put(key, value);
	}

	public void putBoolean(String key, boolean value) {
		values.put(key, String.valueOf(value));
	}

	public void putInt(String key, int value) {
		values.put(key, String.valueOf(value));
	}

	public String get(String key) {
		return values.get(key);
	}

	public String getString(String key) {
		return values.get(key);
	}

	public boolean getBoolean(String key) {
		return Boolean.valueOf(values.get(key));
	}

	public int getInt(String key) {
		return Integer.valueOf(values.get(key));
	}

	public boolean containsKey(String key) {
		return values.containsKey(key);
	}
}