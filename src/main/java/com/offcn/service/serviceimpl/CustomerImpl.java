package com.offcn.service.serviceimpl;

import com.offcn.bean.Customer;
import com.offcn.mapper.CustomerMapper;
import com.offcn.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerImpl implements CustomerService {

    @Resource
    CustomerMapper cusper;

    @Override
    public int saveCust(Customer cus) {
        return cusper.saveCust(cus);
    }

    public List<Customer> getCust(){
        return cusper.getCust();
    }
}
