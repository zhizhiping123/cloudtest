package com.zzping.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter{
    /**
     * pre
     * route
     * post
     * error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("hhhhhh");
        RequestContext currentContext = RequestContext.getCurrentContext();
        String auth = currentContext.getRequest().getHeader("Auth");
        //转发头
        currentContext.addZuulRequestHeader("Auth",auth);
        //验证不通过
        currentContext.setSendZuulResponse(false);
        return null;
    }
}
