package cn.kanyun;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author KANYUN
 */
@SpringBootApplication
@EnableDiscoveryClient   //服务提供者注解[将其信息注册到Eureka Server上面，@EnableDiscoveryClient或者@EnableEurekaClient的区别在于前者是后者的抽象。在Spring Cloud 中，服务发现组件有多种，@EnableDiscoveryClient为各种服务组件提供了支持，而@EnableEurekaClient则只能与Eureka一起工作。在Edgware版本之后，不再需要添加该注解]
public class SpringCloudUserProviderApplication {

    /**
     * https://blog.csdn.net/J080624/article/details/82529082
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringCloudUserProviderApplication.class);
//        添加随机端口监听
        app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        app.run(args);
    }
}
