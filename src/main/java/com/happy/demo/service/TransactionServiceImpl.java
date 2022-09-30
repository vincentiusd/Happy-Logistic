package com.happy.demo.service;

import com.happy.demo.entity.Customer;
import com.happy.demo.entity.Inventory;
import com.happy.demo.entity.Transaction;
import com.happy.demo.exception.NotFoundException;
import com.happy.demo.repository.CustomerRepository;
import com.happy.demo.repository.InventoryRepository;
import com.happy.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void saveNewTransactions(String username, Long id, String paymentMethod) {

        Customer customer = customerRepository.findByUsername(username);

        Inventory inventory = inventoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No inventory found")
        );

        Transaction newTransaction = new Transaction(
                paymentMethod,
                customer,
                inventory
        );
        transactionRepository.save(newTransaction);

    }
}
