package com.kometsales.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@Table(name = "tblcustomerpt", catalog = "kometsales")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name", length = 80)
    private String name;
    @Column(name = "markdown", nullable = false, precision = 5)
    private double markdown;
}
