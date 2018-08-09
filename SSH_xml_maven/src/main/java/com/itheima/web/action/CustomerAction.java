package com.itheima.web.action;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

public class CustomerAction extends ActionSupport implements ModelDriven {
    //模型驱动
    private Customer customer=new Customer();
    //使用spring 注入
    private ICustomerService customerService;
    //将数据压栈
    private List<Customer> customers;


    @Override
    public Object getModel() {
        return customer;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * 查询所有客户
     * @return
     */
    public String  findAllCustomer(){
        customers = customerService.findAllCustomer();
        return "findAllCustomer";
    }

    /**
     * 转到新增客户页面
     * @return
     */
    public String  addUICustomer(){

        return "addUICustomer";
    }

    /*---------getters setters---------------------*/
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
