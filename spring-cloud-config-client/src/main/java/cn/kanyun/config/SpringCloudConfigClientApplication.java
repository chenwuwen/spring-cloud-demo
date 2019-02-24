package cn.kanyun.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud配置仓库
 * 需要注意的是,从配置中心获取配置参数配置,需要将配置中心仓库配置到bootstrap.yml中,因为
 * bootstrap.yml的配置优于application.yml的配置,而bootstrap.yml的加载也是优于application.yml的
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
