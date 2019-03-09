package cn.kanyun.zuul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Zuul作为Netflix组件，可以与Ribbon、Eureka和Hystrix等组件相结合，实现负载均衡、熔断器的功能。
 * 默认情况下Zuul和Ribbon相结合，实现了负载均衡。
 * 实现熔断器功能需要实现FallbackProvider接口，实现该接口的两个方法，
 * 一个是getRoute()，用于指定熔断器功能应用于哪些路由的服务；
 * 另一个方法fallbackResponse()为进入熔断器功能时执行的逻辑。
 */
@Component
@Slf4j
public class FallBackBreaker implements FallbackProvider {
    /**
     * 如果需要所有的路由服务都加熔断功能，需要在getRoute()方法上返回”*“的匹配符
     * @return
     */
    @Override
    public String getRoute() {
        return "provider-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        log.error("=======进入zuul的熔断器======");
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "ok";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                String str = new String("=====进入了熔断器,服务出现问题======");
                return new ByteArrayInputStream(str.getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}