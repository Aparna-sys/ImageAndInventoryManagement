package com.aparna.ImageAndInventory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Image {
	
	@Id
	private String name;
	private String description;
	private byte[] image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
