package com.zy.web;

import com.zy.mapper.UserMapper;
import com.zy.pojo.User;
import com.zy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //2.调用mapper 根据用户名查询对象
        //2.1 获取SqlSessionFactory对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        //2.2 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.3获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //2.4调用方法
        User userNew = userMapper.selectByUsername(username);
        if (userNew == null){
            //用户为空可用，添加用户
            userMapper.add(user);
            //提交事务
            sqlSession.commit();
            //释放资源
            sqlSession.close();
        }else {
            //用户名已存在
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
