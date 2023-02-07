package com.zy.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取请求数据
 */
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头 String getHeader(String name)
        String agent = req.getHeader("user-agent");
        System.out.println(agent);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//因为目前前端传递的是纯文本数据，所以我们采用getReader()方法来获取
        //1.获取字符输入流
        BufferedReader br = req.getReader();
        //2.读取数据
        String line = br.readLine();
        System.out.println(line);
    }
}
