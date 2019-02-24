package cn.kanyun.feign.controller;

import cn.kanyun.feign.entity.User;
import cn.kanyun.feign.service.RpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private RpcService rpcService;

    /**
     * 通过定义好的Feign接口来实现接口调用
     * @return
     */
    @GetMapping("/ticketGetUser/{id}")
    public User ticketGetUser(@PathVariable("id")Long id){
        return rpcService.getRpcUser(id);
    }
}
