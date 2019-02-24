package cn.kanyun.hystrix.controller;

import cn.kanyun.hystrix.entity.User;
import cn.kanyun.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KANYUN
 */
@RestController
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    /**
     *  @Value注解获取application.yml配置文件中,配置的值
     */
//    @Value("${user.userServicePath}")
//    private String userServicePath;

    /**
     * 通过Hystrix定义的方法来进行远程调用
     * @return
     */
    @GetMapping("/ticketGetUser/{id}")
    public User ticketGetUser(@PathVariable("id")Long id){
        User user = hystrixService.getRpcUser(id);
        return user;
    }
}
