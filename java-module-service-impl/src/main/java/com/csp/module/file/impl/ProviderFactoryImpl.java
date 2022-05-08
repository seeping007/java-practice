package com.csp.module.file.impl;

import com.csp.module.file.api.ProviderFactory;
import com.csp.module.file.api.ProviderService;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public final class ProviderFactoryImpl implements ProviderFactory {

    @Override
    public ProviderService create(String provider) {

        return switch (provider) {
            case "aliyun-oss" -> new AliyunOssProviderService();
            case "azure-blob" -> new AzureBlobProviderService();
            default -> new UndefinedProviderService();
        };
    }
}
