package com.zxb.test;

import com.zxb.spring.jdbc.entity.User;
import com.zxb.spring.jdbc.service.UserService;
import com.zxb.spring.jdbc.util.JDBCUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.List;

/**
 * @author Mr.zxb
 * @date 2019-01-11 17:36
 */
public class SpringJDBCTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) context.getBean("userService");

        User user = new User();
        user.setName("张三");
        user.setAge(25);
        user.setSex("男");

//        userService.save(user);

//        List<User> users = userService.getUsers();
        List<User> users = userService.queryUserByCondition(user);
        System.out.println(users);

    }

    @Test
    public void testConnection() {
        try {
            Connection connection = JDBCUtil.getConnection();
            Assert.assertNotNull(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
