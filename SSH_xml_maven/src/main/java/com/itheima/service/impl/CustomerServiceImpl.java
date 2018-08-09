package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;

/**
 * 客户的业务层实现类
 * @author zhy
 *
 */
public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao;


	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}


	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

}
