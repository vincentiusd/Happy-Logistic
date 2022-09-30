package com.happy.demo.repository;

import com.happy.demo.dto.customer.CustomerGridDTO;
import com.happy.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, Long> {



    @Query("""
            SELECT new com.happy.demo.dto.customer.CustomerGridDTO(cus.id, acc.username, cus.name, cus.phone, cus.address)
            FROM Customer cus
            JOIN cus.account acc
            """)
    public Page<CustomerGridDTO> findAllDTOPage(Pageable pageable);



    @Query("""
            SELECT new com.happy.demo.dto.customer.CustomerGridDTO(cus.id, acc.username, cus.name, cus.phone, cus.address)
            FROM Customer cus
            JOIN cus.account acc
            WHERE cus.id = :id
            """)
    public CustomerGridDTO findDTOById(@Param("id") long id);

    @Query("select c from Customer c where c.account.username = ?1")
    Customer findByUsername(String username);






}