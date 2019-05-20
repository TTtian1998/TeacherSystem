package com.tianZeXin.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 田泽鑫
 * @date 2019/5/13
 */
public class CommonFilter implements Filter {
    private static List<String> urls = new ArrayList<>();
    //静态代码块中向集合中存放所有可以放行的请求或网页地址（不用账号密码即可访问）
    static {
        urls.add("/jsp/login.jsp");
        urls.add("/css");
        urls.add("/js/login.js");
        urls.add("/js/jquery");
        urls.add("/images");
        urls.add("Login");
        urls.add("Servlet");
    }

    @Override
    public void destroy(){

        System.out.println("filter销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
        //得到当前页面所在目录下全名称
        String urlPattern=req.getServletPath();
        //得到页面所在服务器的绝对路径
        String path = req.getRequestURI();
        for (String url : urls) {
            if(url.equals(urlPattern) || path.contains(url)) {
                //System.out.println("reaource do chain...");
                //System.out.println(url);
                //System.out.println(path);
                chain.doFilter(request, response);
                //防止重复响应
                return;
            }
        }
        if(req.getSession().getAttribute("username")==null) {
            res.sendRedirect("login.jsp");
        }else {
            //放行
            chain.doFilter(request, response);
        }
    }


    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("----Filter初始化----");
    }

}
