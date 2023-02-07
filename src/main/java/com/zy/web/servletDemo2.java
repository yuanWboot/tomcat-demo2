package com.zy.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class servletDemo2 implements Servlet {
    /**
     * 初始化方法
     * 调用时机：默认情况下，servlet被第一次访问时调用
     * 调用次数：只调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.........");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 调用时机：访问servlet时调用
     * 调用次数:多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("6666666666666666666666");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法：
     * 调用时机：内存释放或者服务器被关闭的时候，servlet对象会被摧毁
     * 调用次数：一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy........");
    }
}
