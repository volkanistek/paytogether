package com.paytogether.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "activities")
@Data
@Builder
public class Activity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User organizer;
}
