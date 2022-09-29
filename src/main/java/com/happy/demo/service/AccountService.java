package com.happy.demo.service;

import com.happy.demo.dto.account.RegisterDTO;

public interface AccountService {


    String getAccountRole(String username);


    Boolean checkExistingUsername(String username);

    void register(RegisterDTO dto);
}
