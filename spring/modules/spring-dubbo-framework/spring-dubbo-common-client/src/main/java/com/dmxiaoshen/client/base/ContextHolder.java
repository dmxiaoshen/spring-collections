package com.dmxiaoshen.client.base;

import java.util.Map;

public class ContextHolder {
	public static final ThreadLocal<Map<String,String>> contextHolder = new ThreadLocal<>();
			
}
