package com.csp.module.file.api;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public interface ProviderFactory {

    ProviderService create(String provider);
}
