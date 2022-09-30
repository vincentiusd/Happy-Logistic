package com.happy.demo.service;

public interface TransactionService {
    void saveNewTransactions(String username, Long id, String paymentMethod);
}
