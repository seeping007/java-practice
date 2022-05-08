package com.csp.module.file.api;

import java.util.ServiceLoader;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public interface ProviderService {

    String provider();

    static ProviderService of(String provider) {

        // SPI机制：使用ServiceLoader来加载接口的实现，实现动态实现扩展（类似IOC）
        ServiceLoader<ProviderFactory> serviceLoader = ServiceLoader.load(ProviderFactory.class);
        for (ProviderFactory providerFactory : serviceLoader) {

            ProviderService providerService = providerFactory.create(provider);
            if (providerService != null) {
                return providerService;
            }
        }

        throw new IllegalArgumentException("Invalid provider");
    }
}
