package com.kometsales.inventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "tblinventorypt", catalog = "kometsales")
@NoArgsConstructor
public class InventoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boxTypeId", nullable = false)
    private BoxTypeEntity boxTypeEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", nullable = false)
    private CompanyEntity companyEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private ProductEntity productEntity;
    @Column(name = "cubesPerCarrier", nullable = false, scale = 5)
    private double cubesPerCarrier;
    @Column(name = "pack", nullable = false)
    private int pack;
    @Column(name = "basePrice", nullable = false, precision = 10, scale = 5)
    private double basePrice;
}
