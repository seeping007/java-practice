package com.csp.module.controller;

import com.csp.module.file.api.ProviderService;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public class FileController {

    public static void main(String[] args) {

        String provider = "aliyun-oss";
        ProviderService providerService = ProviderService.of(provider);
        System.out.println(">>>>>> Current provider: " + providerService.provider());
    }
}
