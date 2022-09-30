package com.happy.demo.service;

import com.happy.demo.dto.customer.CustomerGridDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<CustomerGridDTO> findAllDTO(Pageable pageable);
}
