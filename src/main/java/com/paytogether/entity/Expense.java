package com.paytogether.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "expenses")
@Data
@Builder
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
