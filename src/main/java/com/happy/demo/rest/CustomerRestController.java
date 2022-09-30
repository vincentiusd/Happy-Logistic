package com.happy.demo.rest;


import com.happy.demo.dto.customer.CustomerGridDTO;
import com.happy.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    //get a list of customer from database
    @GetMapping
    public ResponseEntity<Object> getAllCustomer(
            @RequestParam(defaultValue = "1") Integer page
    ){
        Pageable pageable = PageRequest.of(page - 1,10, Sort.by("id"));

        Page<CustomerGridDTO> customerPage = customerService.findAllDTO(pageable);

        if(page > customerPage.getTotalPages()){
            throw new RuntimeException("Page not found");
        }

        return new ResponseEntity<>(customerPage, HttpStatus.OK);

    }
}
