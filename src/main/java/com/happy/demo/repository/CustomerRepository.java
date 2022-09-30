package com.happy.demo.repository;

import com.happy.demo.dto.customer.CustomerGridDTO;
import com.happy.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //SELECT new indocyber.exam.dto.admin.AdminGridDTO(acc.username, ad.jobTitle)
    //            FROM Admin ad
    //            JOIN ad.account acc

    //Long id, String username, String name, String phone, String address

    @Query("""
            SELECT new com.happy.demo.dto.customer.CustomerGridDTO(cus.id, acc.username, cus.name, cus.phone, cus.address)
            FROM Customer cus
            JOIN cus.account acc
            """)
    public Page<CustomerGridDTO> findAllDTOPage(Pageable pageable);
}