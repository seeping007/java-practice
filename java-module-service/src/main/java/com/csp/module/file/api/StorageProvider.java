package com.csp.module.file.api;

/**
 * @author chensiping
 * @since 2022-05-08
 */
public enum StorageProvider {

    ALIYUN_OSS(0, "aliyun-oss"),
    NFS(1, "nfs"),
    AZURE_BLOB(2, "azure-blob"),
    AWS(3, "aws"),
    MINIO(4, "minio");

    private final int index;

    private final String name;

    StorageProvider(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
