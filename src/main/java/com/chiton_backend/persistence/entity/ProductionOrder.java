package com.chiton_backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "production_order")
public class ProductionOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "generation_date", nullable = false, updatable = false)
    private LocalDate generationDate;

    @Column( name = "completed_date")
    private LocalDate completedDate;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;
    private String completed;

    @OneToMany(mappedBy = "production_order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductionDetail> details;

    @OneToOne(orphanRemoval = true)
    private TranslateOrder translateOrder;
}
