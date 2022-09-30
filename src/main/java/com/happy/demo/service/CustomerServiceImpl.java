package com.happy.demo.service;

import com.happy.demo.dto.customer.CustomerGridDTO;
import com.happy.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<CustomerGridDTO> findAllDTO(Pageable pageable) {
        return customerRepository.findAllDTOPage(pageable);
    }
}
