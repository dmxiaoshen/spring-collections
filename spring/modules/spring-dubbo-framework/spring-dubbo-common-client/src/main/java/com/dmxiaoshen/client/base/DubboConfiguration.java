package com.dmxiaoshen.client.base;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import java.util.Map;

public class DubboConfiguration {

	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		Map<String,String> config = ContextHolder.contextHolder.get();
		applicationConfig.setName(config.get("appName"));
		return applicationConfig;
	}

	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		Map<String,String> config = ContextHolder.contextHolder.get();
		registryConfig.setAddress(config.get("zkAddress"));
		registryConfig.setTimeout(Integer.valueOf(100000));
		return registryConfig;
	}

}
