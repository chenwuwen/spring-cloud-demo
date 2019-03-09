package cn.kanyun.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringCloud bus消息总线
 * 目前Spring Cloud Bus 支持 RabbitMQ 和 Kafka
 * 分别对应 spring-cloud-starter-bus-amqp 、spring-cloud-starter-bus-kafka
 * @author KANYUN
 */
@SpringBootApplication
/**
 * 服务发现注解
 */
@EnableDiscoveryClient

public class SpringCloudBusClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusClientApplication.class, args);
    }
}
