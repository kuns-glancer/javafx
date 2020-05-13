package saber.kuns.util;

import java.util.UUID;

public class IdGen {

	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 调用存储过程生成id
	 * 
	 * @param suffix
	 * @return
	 */
	public static String genId(String suffix) {
		// TODO
		return null;
	}

}
