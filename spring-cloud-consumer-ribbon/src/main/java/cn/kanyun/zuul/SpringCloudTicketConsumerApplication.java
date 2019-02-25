package cn.kanyun.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author KANYUN
 */
@SpringBootApplication
/**
 * 消费端也需要向注册中心注册
 */
@EnableDiscoveryClient
public class SpringCloudTicketConsumerApplication {
    /**相当于初始化时就注入了RestTemplate，使用的时候直接AutoWrite*/
    @Bean
    /**
     * 负载均衡[需要注意的是该注解必须添加,否则无法访问Eureka上注册的服务,会报错：UnknownHostException]
     * 不管访问的服务有几个实例,都应该添加此注解
     */
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTicketConsumerApplication.class,args);
    }
}
