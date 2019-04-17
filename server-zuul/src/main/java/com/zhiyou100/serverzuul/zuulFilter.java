package com.zhiyou100.serverzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class zuulFilter extends ZuulFilter {
    /**
     * filterType: 返回一个字符串代表过滤器的类型
     * 在zuul中定义了四种不同的声明周期的过滤器类型,
     * pre:路由之前
     * routing:路由之时
     * post:路由之后
     * error:发送错误时调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否使用过滤器
     * true:使用
     * false:不使用
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("api-a/")) {

            try {

                context.setSendZuulResponse(false);
                context.getResponse().getWriter().print("滚");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        return null;
    }
}
