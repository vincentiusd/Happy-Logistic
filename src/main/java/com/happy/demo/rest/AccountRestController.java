package com.happy.demo.rest;

import com.happy.demo.JwtToken;
import com.happy.demo.dto.account.RegisterDTO;
import com.happy.demo.dto.account.RequestTokenDTO;
import com.happy.demo.dto.account.ResponseTokenDTO;
import com.happy.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtToken jwtToken;

    //login to the web app using username and password
    @PostMapping("/login")
    public ResponseTokenDTO login(
            @RequestBody RequestTokenDTO dto){

        try{
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

            Authentication authentication = authenticationManager.authenticate(token);

        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can not authenticate", e);
        }

        String role = accountService.getAccountRole(dto.getUsername());

        String token = jwtToken.generateToken(
                dto.getSubject(),
                dto.getUsername(),
                dto.getSecretKey(),
                role,
                dto.getAudience());

        ResponseTokenDTO responseTokenDTO = new ResponseTokenDTO(dto.getUsername(), role, token);

        return responseTokenDTO;

    }

    //register to the web app as a customer
    @PostMapping("/register")
    public ResponseEntity<Object> addAccount(@Valid @RequestBody RegisterDTO dto){

        accountService.register(dto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


}
