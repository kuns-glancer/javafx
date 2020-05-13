package saber.kuns.config;

import java.util.HashMap;
import java.util.Map;

/**
 * convert var between windows
 * 
 * @author shenk
 *
 */
public class Model {

	private static Map<String, Object> map;

	static {
		if (map == null) {
			map = new HashMap<>();
		}
	}

	public static void addAttribution(String attrName, Object attrVal) {
		map.put(attrName, attrVal);
	}

	public static Object getAttributionByName(String attrName) {
		return map.get(attrName);
	}

	public static void removeAttribution(String attrName) {
		map.remove(attrName);
	}


	public static void clear() {
		map.clear();
	}
}
