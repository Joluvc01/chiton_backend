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
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "generation_date", nullable = false, updatable = false)
    private LocalDate generationDate;

    private String completed;

    @OneToMany(mappedBy = "purchase_order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseDetail> details;
}
