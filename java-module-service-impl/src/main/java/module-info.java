/**
 * @author chensiping
 * @since 2022-05-08
 */
module csp.module.file.impl {

    // 需要引用的模块（明确了依赖关系）
    requires csp.module.file;

    // 实现了定义的服务接口
    provides com.csp.module.file.api.ProviderFactory with com.csp.module.file.impl.ProviderFactoryImpl;

    // 没有export：即使有使用public修饰的接口，也不能被外部访问（外部不可直接访问实现类，达到封装效果）
}