package cn.kanyun.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * SpringCloud配置仓库客户端
 * 需要注意的是,从配置中心获取配置参数配置,需要将配置中心仓库配置到bootstrap.yml中,因为
 * bootstrap.yml的配置优于application.yml的配置,而bootstrap.yml的加载也是优于application.yml的
 * @author KANYUN
 */
@SpringBootApplication
/**
 * 服务发现注解
 */
@EnableDiscoveryClient
/**
 * 这个注解是配置刷新的注解,如果配置中心中的信息发生变化的话，客户端的信息是不会跟着变化的
 * 需要增加一个监控模块：spring-boot-starter-actuator 在pom.xml中增加依赖
 * 并且在Controller中增加@RefreshScope注解。
 * actuator给我们提供了一个/refresh接口，修改完git仓库信息之后，向这个接口发送一个POST信息，
 * 就会更新配置信息了。
 */
@RefreshScope
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }
}
