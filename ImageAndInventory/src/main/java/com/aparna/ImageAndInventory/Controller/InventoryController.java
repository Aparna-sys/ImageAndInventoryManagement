package com.aparna.ImageAndInventory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aparna.ImageAndInventory.Service.InventoryService;
import com.aparna.ImageAndInventory.entities.Inventory;

@RestController
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;

	@RequestMapping(value="/inventory",method=RequestMethod.POST)
	public Inventory createItem(@RequestParam("item") String item,
			@RequestParam("category") String category,
			@RequestParam("status") String status,
			@RequestParam("stock") int stock) {
	 return	inventoryService.saveItem(item,category,status,stock);
		
	}
	
	@RequestMapping(value="/inventory", method= RequestMethod.PUT)
	public Inventory updateStatus(@RequestParam("id") int id,
			@RequestParam("status") String status) {
		return inventoryService.updateStatus(id,status);
	}
	
	@RequestMapping(value="/inventory",method=RequestMethod.GET)
	public List<Inventory> getInfo() {
		return inventoryService.getInfo();
	}
	
	/*@RequestMapping("/inventory")
	public ModelAndView getInfo() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("getResultDiv",inventoryService.getInfo());
		return mav;
	}*/
	
	@RequestMapping(value="/inventory",method=RequestMethod.DELETE)
	public String deleteItem(@RequestParam("id") int id) {
		return inventoryService.deleteItem(id);
	}
	
	@RequestMapping(value="/inventory/stock",method=RequestMethod.GET)
	public String getStock(@RequestParam("id") int id) {
		return inventoryService.getStock(id);
	}
}
