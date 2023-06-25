package com.aparna.ImageAndInventory.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aparna.ImageAndInventory.entities.Image;
import com.aparna.ImageAndInventory.repos.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	ImageRepository imageRepository;

	public String saveImage(MultipartFile file, String name, String description) throws IOException {
		Image image = new Image();
		image.setName(name);
		image.setDescription(description);
		image.setImage(file.getBytes());
		imageRepository.save(image);
		return "Image Saved in Database";
	}
	
	/*public byte[] viewImage(String name) {
		for(Image image: imageRepository.findAll()) {
			if(image.getName().equalsIgnoreCase(name))
			{
				return image.getImage();
			}
		}
		return null;
	}
	
	 public List<Image> viewImage() {
		 return imageRepository.findAll();
	 }*/
	 
	 public byte[] viewImage() {
		 return imageRepository.findAll().get(0).getImage();
	 }
}
