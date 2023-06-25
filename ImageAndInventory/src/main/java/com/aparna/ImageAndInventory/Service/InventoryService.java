package com.aparna.ImageAndInventory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aparna.ImageAndInventory.entities.Inventory;
import com.aparna.ImageAndInventory.repos.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	public Inventory saveItem(String item, String category, String status, int stock) {
		Inventory inventory = new Inventory();
		inventory.setItem(item);
		inventory.setCategory(category);
		inventory.setStatus(status);
		inventory.setStock(stock);
		return inventoryRepository.save(inventory);
	}
	
	public Inventory updateStatus(int id, String status) {
		for(Inventory inventory : inventoryRepository.findAll())
		{
			if(inventory.getId()==id)
			{
				inventory.setStatus(status);
				inventoryRepository.save(inventory);
			}
		}	
		return inventoryRepository.findById(id).get();
	}
	
	public List<Inventory> getInfo() {
		return inventoryRepository.findAll();
	}
	
	public String deleteItem(int id) {
		inventoryRepository.deleteById(id);
		return "Item Deleted";
	}
	
	public String getStock(int id) {
		int stock;
		for(Inventory inventory : inventoryRepository.findAll())
		{
			if(inventory.getId()==id)
			{
				stock = inventory.getStock();
				return "Stock for the item is:"+stock;
			}
		}	
		return "Not having such item";
	}
}
