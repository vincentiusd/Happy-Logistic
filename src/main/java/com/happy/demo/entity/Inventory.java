package com.happy.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Inventory_Type")
    private String type;

    @Column(name = "Monthly_Rent")
    private BigDecimal rent;

    public Inventory() {
    }

    public Inventory(Long id, String type, BigDecimal price) {
        this.id = id;
        this.type = type;
        this.rent = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }
}
