package com.offcn.service;

import com.offcn.bean.Customer;

import java.util.List;

public interface CustomerService {


    public int saveCust(Customer cus);

    public List<Customer> getCust();

}
