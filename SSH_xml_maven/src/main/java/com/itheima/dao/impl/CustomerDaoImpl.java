package com.itheima.dao.impl;

import java.util.List;
import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * 客户的持久层实现类
 * @author zhy
 *
 */
public class CustomerDaoImpl implements ICustomerDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public List<Customer> findAllCustomer() {
        return (List<Customer>) hibernateTemplate.find("from Customer");
	}


	public void saveCustomer(Customer customer) {
        hibernateTemplate.save(customer);
	}

}
