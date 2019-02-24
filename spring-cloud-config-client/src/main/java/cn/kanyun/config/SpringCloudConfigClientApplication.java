package cn.kanyun.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud配置仓库
 *
 * @author KANYUN
 */
@SpringBootApplication
/**
 * 服务发现注解
 */
@EnableDiscoveryClient
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }
}
