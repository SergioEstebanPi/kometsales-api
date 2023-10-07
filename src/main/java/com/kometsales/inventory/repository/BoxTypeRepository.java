package com.kometsales.inventory.repository;

import com.kometsales.inventory.entity.BoxTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxTypeRepository extends JpaRepository<BoxTypeEntity, Integer> {
}
