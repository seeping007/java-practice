/**
 * @author chensiping
 * @since 2022-05-08
 */
module csp.module.file { // 模块名称

    // 允许外部访问的公开接口：exports + public
    exports com.csp.module.file.api;

    // 直接使用的服务接口
    uses com.csp.module.file.api.ProviderFactory;
}