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
@Table(name = "tblboxtypept", catalog = "kometsales")
@NoArgsConstructor
@AllArgsConstructor
public class BoxTypeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "code", length = 80)
    private String code;
    @Column(name = "width", nullable = false, precision = 10, scale = 5)
    private double width;
    @Column(name = "height", nullable = false, precision = 10, scale = 5)
    private double height;
    @Column(name = "length", nullable = false, precision = 10, scale = 5)
    private double length;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "boxTypeEntity")
    @JsonIgnore
    @Builder.Default
    private Set<InventoryEntity> inventoryEntities = new HashSet<>(0);
}
