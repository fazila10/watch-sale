package com.accenture.imaginea.dao;

import com.accenture.imaginea.entity.Inventory;
import com.accenture.imaginea.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    @Query("SELECT i FROM Inventory i WHERE i.product.id = :productId")
    Inventory findByProductId(Integer productId);
}
