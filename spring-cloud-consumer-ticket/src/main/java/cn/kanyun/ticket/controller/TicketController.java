package cn.kanyun.ticket.controller;

import cn.kanyun.ticket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TicketController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     *  @Value注解获取application.yml配置文件中,配置的值
     */
    @Value("${user.userServicePath}")
    private String userServicePath;

    /**
     * 通过RestTemplate直接调用User项目的getUser接口；与传统调用不同，SpringCloud直接调用的是提供者的@Controller
     * @param id：查询的参数 ，url：提供者方法的url
     * @return
     */
    @GetMapping("/ticketGetUser/{id}")
    public User ticketGetUser(@PathVariable("id")Long id){
//        return this.restTemplate.getForObject("http://localhost:7900/getUser/"+id,User.class);
        return this.restTemplate.getForObject(this.userServicePath+id,User.class);
    }
}
