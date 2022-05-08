package com.csp.module.file.impl;

import com.csp.module.file.api.ProviderService;

/**
 * @author chensiping
 * @since 2022-05-08
 */
final class UndefinedProviderService implements ProviderService {

    @Override
    public String provider() {
        return "undefined";
    }
}
