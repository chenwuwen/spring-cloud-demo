package cn.kanyun.hystrix.service;

import cn.kanyun.hystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 使用Hystrix来调用远程接口,Hystrix具备拥有回退机制和
 * 断路器功能的线程和信号隔离，请求缓存和请求打包，以及监控和配置等功能
 * 当某个服务单元发⽣故障（类似⽤电器发⽣短路）
 * 之后，通过断路器的故障监控（类似熔断保险丝），向调⽤⽅返回⼀个错误响应，⽽不是⻓时间的等
 * 待。这样就不会使得线程因调⽤故障服务被⻓时间占⽤不释放，避免了故障在分布式系统中的蔓延
 * @author KANYUN
 */
@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注解表示调用失败【包括执行超时】执行哪个方法,需要注意的是
     * 回调方法,必须与被注解方法入参一致,否则回报错：fallback method wasn't found: xxxx
     * 同时此回调方法的返回类型必须与被注解方法的返回类型一致，或是被注解方法的返回值的子类，否则会报错
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "rpcErrorMethod")
    public User getRpcUser(Long id) {
        return this.restTemplate.getForObject("http://provider-service/getUser/"+id,User.class);
    }

    /**
     * 远程访问，报错【包括执行超时】回调方法
     * 需要注意的是
     * 回调方法,必须与被注解方法入参一致,否则回报错：fallback method wasn't found: xxxx
     * 同时此回调方法的返回类型必须与被注解方法的返回类型一致，或是被注解方法的返回值的子类
     * @return
     */
    public User rpcErrorMethod(Long id) {
        System.out.println("========== ribbon rpc error , select id :"+ id +"==========");
        User user =  User.builder().id(999L).sex('z').age((short) 0).username("hystrix rpc error").build();
        return user;
    }

}