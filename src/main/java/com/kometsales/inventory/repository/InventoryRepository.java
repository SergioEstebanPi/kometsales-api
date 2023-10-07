package com.kometsales.inventory.repository;

import com.kometsales.inventory.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
    List<InventoryEntity> findByCompanyId(int companyId);
}
