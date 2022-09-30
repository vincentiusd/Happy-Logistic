package com.happy.demo.rest;

import com.happy.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsRestController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/{id}")
    private ResponseEntity<?> newTransactions(
            @PathVariable Long id,
            @RequestBody String paymentMethod
    ){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        transactionService.saveNewTransactions(username, id, paymentMethod);

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }


}
