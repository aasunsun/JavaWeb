package com.bjpowernode.listener;

import com.bjpowernode.pojo.Myusers;
import com.bjpowernode.service.MyusersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;


@WebListener
public class MyusersListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_*.xml");
        MyusersService myusersService = (MyusersService) context.getBean("MyusersServiceImpl");
        List<Myusers> myusersList = myusersService.getAll();
        servletContextEvent.getServletContext().setAttribute("myusersList",myusersList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
