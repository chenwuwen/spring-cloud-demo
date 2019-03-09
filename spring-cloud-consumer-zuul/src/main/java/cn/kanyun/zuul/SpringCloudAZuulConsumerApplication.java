package cn.kanyun.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul网关
 * 本例 可以使用 http://localhost:7800/v1/zuul-a/getUser/1?accessToken="XXX" 测试
 * @author KANYUN
 */

/**
 * @SpringCloudApplication整合了 @SpringBootApplication @EnableDiscoveryClient
 *  @EnableCircuitBreaker  ，主要⽬的还是简化配置
 */
@SpringCloudApplication
/**
 * 开启Zuul
 */
@EnableZuulProxy
public class SpringCloudAZuulConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAZuulConsumerApplication.class,args);
    }
}
