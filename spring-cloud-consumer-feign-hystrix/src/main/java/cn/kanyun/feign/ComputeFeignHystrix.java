package cn.kanyun.feign;

import cn.kanyun.feign.entity.User;
import cn.kanyun.feign.service.RpcService;
import org.springframework.stereotype.Component;

/**
 * Feign使用Hystrix的错误回调类,需要实现Feign接口
 * @author KANYUN
 */
@Component
public class ComputeFeignHystrix implements RpcService {
    @Override
    public User getRpcUser(Long id) {
        System.out.println("============feign-hystrix error============");
        User user = User.builder().age((short) 0).id(999L).sex('z').username("feign-hystrix error").build();
        return user;
    }
}