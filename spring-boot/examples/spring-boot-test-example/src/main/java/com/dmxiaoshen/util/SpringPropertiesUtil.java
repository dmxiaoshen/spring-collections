package com.dmxiaoshen.util;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Created by hzhsg on 2017/12/14.
 */
@Component
public class SpringPropertiesUtil implements EmbeddedValueResolverAware {

    private static StringValueResolver resolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        if (resolver == null) {
            resolver = stringValueResolver;
        }
    }

    /**
     * 获取spring配置文件信息, 此处应该是 "${key}" 获取
     * @param key
     * @return
     */
    public static String getPropertiesValue(String key) {
        return resolver.resolveStringValue(key);
    }
}
