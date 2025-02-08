package com.chiton_backend.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "reference")
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String image;
    private String status;

    @OneToMany(mappedBy = "reference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReferenceDetail> details;

    @OneToMany(mappedBy = "reference", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ProductionDetail> productionDetails;
}
