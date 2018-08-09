package com.itheima.test;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {


    @Test
    public void  method(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ICustomerService customerService = (ICustomerService) applicationContext.getBean("customerService");
        List<Customer> allCustomer = customerService.findAllCustomer();
        for (Customer customer : allCustomer) {
            System.out.println(customer);
        }
    }
    @Test
    public void  method3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ICustomerService customerService = (ICustomerService) applicationContext.getBean("customerService");
        Customer c = new Customer();
        c.setCustName("ssh 整合 好玩");
        customerService.saveCustomer(c);
    }

    @Test
    public void method1(){
        Configuration  configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Customer customer = session.get(Customer.class, 1l);
        System.out.println(customer);
        tx.commit();
        sessionFactory.close();
    }
}
