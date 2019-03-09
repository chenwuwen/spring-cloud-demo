package cn.kanyun.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * SpringCloud配置仓库 bus 消息总线方式
 * 使用bus总线做配置中心的最大的好处就是,当有多个实例都依赖配置中心的配置时,
 * 使用BUS总线,只需要往一个实例上发送刷新指令,那么其他实例也可以同步进行刷新(也就是说如果使用了github的webhook也仅需发送一次请求即可)
 * 这也是为什么采用bus机制,而普通的配置中心,当配置变更时,要分别向每个实例发送刷新请求,才能实现配置更新
 * 该模块使用了Kafaka做消息队列,目前springboot只支持rabbitmq和kafaka
 *
 * @author KANYUN
 */
@SpringBootApplication
/**
 * 服务发现注解
 */
@EnableDiscoveryClient
/**
 * 激活配置中心服务。配置中心可以单独做服务，也可以嵌入到其它服务中。推荐用单独做服务方式使用配置中心
 */
@EnableConfigServer
public class SpringCloudBusServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusServerApplication.class, args);
    }
}
