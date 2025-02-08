package com.chiton_backend.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "translate_order")
public class TranslateOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "production_id")
    private ProductionOrder productionOrder;

    @Temporal(TemporalType.DATE)
    @Column(name = "generation_date", updatable = false)
    private LocalDate generationDate;

    private String completed;
}
