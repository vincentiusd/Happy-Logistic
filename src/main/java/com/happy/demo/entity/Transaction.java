package com.happy.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Payment_Type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Inventory_Id")
    private Inventory inventory;

    public Transaction() {
    }

    public Transaction(Long id, String type, Customer customer, Inventory inventory) {
        this.id = id;
        this.type = type;
        this.customer = customer;
        this.inventory = inventory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
