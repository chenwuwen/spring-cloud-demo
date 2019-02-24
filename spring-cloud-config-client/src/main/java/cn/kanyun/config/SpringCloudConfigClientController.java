package cn.kanyun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试springcloud 配置仓库是能够获取配置信息
 * @author KANYUN
 */
@RestController
public class SpringCloudConfigClientController {

    @Value("${name}")
    private String name;

    @Value("${sex}")
    private String sex;

    @Value("${age}")
    private int age;

    @GetMapping("/")
    public String testSpringCloudServer() {
        System.out.println(name + ":" + sex + ":" + age);
        return name + ":" + sex + ":" + age;
    }

}