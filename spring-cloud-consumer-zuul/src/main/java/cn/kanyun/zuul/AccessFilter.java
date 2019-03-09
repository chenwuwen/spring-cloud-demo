package cn.kanyun.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 利⽤Zuul的过滤器来实现我们对外服务的安全控制
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    /**
     * filterType  ：返回⼀个字符串代表过滤器的类型，在zuul中定义了四种不同⽣命周期的过滤器类型
     * pre  ：可以在请求被路由之前调⽤
     * routing  ：在路由请求时候被调⽤
     * post  ：在routing和error过滤器之后被调⽤
     * error  ：处理请求时发⽣错误时被调⽤
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder  ：通过int值来定义过滤器的执⾏顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter  ：返回⼀个boolean类型来判断该过滤器是否要执⾏，所以通过此函数可实现过滤
     * 器的开关,true表示执行，false表示不执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run  ：过滤器的具体逻辑。需要注意，这⾥我们通过 ctx.setSendZuulResponse(false)  令zuul
     * 过滤该请求，不对其进⾏路由，然后通过 ctx.setResponseStatusCode(401)  设置了其返回的错
     * 误码，当然我们也可以进⼀步优化我们的返回，⽐如，通过 ctx.setResponseBody(body)  对返
     * 回body内容进⾏编辑等
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}