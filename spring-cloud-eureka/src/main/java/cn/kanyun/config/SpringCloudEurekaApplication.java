package cn.kanyun.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心
 *
 * @author KANYUN
 */
@SpringBootApplication

/**
 * 服务发现注解
 * [Eureka Server 同时也是 Client，多个Eureka Server 实例之间可以通过
 * 复制的方法来实现服务注册表数据的同步]
 */
@EnableEurekaServer
public class SpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaApplication.class, args);
    }
}
