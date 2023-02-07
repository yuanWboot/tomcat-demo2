package com.zy.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //String getMethod() 获取请求方式
        String method = req.getMethod();
        System.out.println(method);

        //String getContextPath() 获取虚拟路径，项目访问路径
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        //获取URL(统一资源定位符): `http://localhost:8080/request-demo/req1`
        // StringBuffer getRequestURL()
        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        //获取请求参数(GET方式) String getQueryString() username=zhangsan&password=123y

        String queryString = req.getQueryString();
        System.out.println(queryString);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
