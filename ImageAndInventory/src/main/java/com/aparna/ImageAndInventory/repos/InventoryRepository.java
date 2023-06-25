package com.aparna.ImageAndInventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aparna.ImageAndInventory.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
