package com.happy.demo.service;

import com.happy.demo.ApplicationUserDetails;
import com.happy.demo.dto.account.RegisterDTO;
import com.happy.demo.entity.Account;
import com.happy.demo.entity.Customer;
import com.happy.demo.repository.AccountRepository;
import com.happy.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Account> optionalAccount = accountRepository.findById(username);

        Account tempAccount = null;
        if(optionalAccount.isPresent()){
            tempAccount = optionalAccount.get();
        }

        return new ApplicationUserDetails(tempAccount);
    }

    @Override
    public String getAccountRole(String username) {
        Optional<Account> optionalAccount = accountRepository.findById(username);

        Account account = optionalAccount.get();
        return account.getRole();
    }

    @Override
    public Boolean checkExistingUsername(String username) {
        Long totalUsernameExist = accountRepository.checkUsernameByCount(username);
        return totalUsernameExist > 0;
    }

    @Override
    public void register(RegisterDTO dto) {
        String passwordEncrypt = passwordEncoder.encode(dto.getPassword());



        Account account = new Account(
                dto.getUsername(),
                passwordEncrypt,
                "Customer"
        );

        accountRepository.save(account);

        //String name, String phone, String address, Account account
        Customer customer = new Customer(
                dto.getName(),
                dto.getPhone(),
                dto.getAddress(),
                account
        );

        customerRepository.save(customer);


    }
}
