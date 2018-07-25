package com.offcn.mapper;


import com.offcn.bean.Customer;

import java.util.List;

public interface CustomerMapper {

    public int saveCust(Customer cus);

    public List<Customer> getCust();

}
