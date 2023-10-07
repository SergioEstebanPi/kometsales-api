package com.kometsales.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
@Table(name = "tblcompanypt", catalog = "kometsales")
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "name", length = 80)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companyEntity")
    @JsonIgnore
    @Builder.Default
    private Set<InventoryEntity> inventoryEntities = new HashSet<>(0);
}
