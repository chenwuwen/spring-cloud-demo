package cn.kanyun.feign.service;

import cn.kanyun.feign.ComputeFeignHystrix;
import cn.kanyun.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 需要注意的是@FeignClient注解里的值.是服务提供者接口名,
 * 即服务提供者模块配置文件[yml文件或properties文件]中的 spring.application.name 的值
 * fallback为调用报错,或者超时时的回调类
 */
@FeignClient(value = "provider-service",fallback = ComputeFeignHystrix.class)
public interface RpcService {

    /**
     * 此注解中值为,服务提供者的方法中的值 一致,
     * 即通过上面类的FeignClient 注解,知道了调用哪个服务,而这个方法
     * 则是调用服务里的哪个方法,需要调哪个方法,就去服务模块找对应的路径
     * 并写入到注解中去
     * @param id
     * @return
     */
    @GetMapping("/getUser/{id}")
    User getRpcUser(@PathVariable("id") Long id);

}