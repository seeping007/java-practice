package com.csp.module.file.impl;

import com.csp.module.file.api.ProviderService;

/**
 * @author chensiping
 * @since 2022-05-08
 */
final class AzureBlobProviderService implements ProviderService {

    @Override
    public String provider() {
        return "azure-blob";
    }
}
