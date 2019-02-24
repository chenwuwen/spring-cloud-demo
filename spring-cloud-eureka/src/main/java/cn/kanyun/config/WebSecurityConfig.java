package cn.kanyun.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * @author KANYUN
 */
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        //关闭csrf,否则Eureka客户端向服务端注册时会报错,连接不上服务端[statusCode=403],报错[TransportException: Cannot execute request on any known server],新版本SpringCloud存在此问题
        httpSecurity.csrf().disable();
    }
}