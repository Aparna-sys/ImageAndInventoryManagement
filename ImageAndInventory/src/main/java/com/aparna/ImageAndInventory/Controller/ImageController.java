package com.aparna.ImageAndInventory.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aparna.ImageAndInventory.Service.ImageService;
import com.aparna.ImageAndInventory.entities.Image;
import com.aparna.ImageAndInventory.entities.Inventory;

@RestController
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@RequestMapping(value="/{image}",method=RequestMethod.POST)
	public String uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, 
			@RequestParam("description") String description) throws IOException {	
		return imageService.saveImage(file,name,description);
	}
	
	
	  /*@RequestMapping(value="/image",method=RequestMethod.GET) 
	  public ResponseEntity<?> viewImage(@RequestParam("name") String name) {
		  byte[] imageData= imageService.viewImage(name);
		  return ResponseEntity.status(HttpStatus.OK)
				  .contentType(MediaType.valueOf("image/png"))
				  .body(imageData);
	  }
	
	@RequestMapping(value="/image",method=RequestMethod.GET)
	public List<ResponseEntity<?>> viewImage() {
		List<Image> imageLst= imageService.viewImage();
		List<ResponseEntity<?>> imageList = new ArrayList<>();
		 for(Image image: imageLst) {
			 imageList.add(ResponseEntity.status(HttpStatus.OK)
			  .contentType(MediaType.valueOf("image/png"))
			  .body(image.getImage()));
		 }
		 return imageList;
	}*/
	  
	  @RequestMapping(value="/image",method=RequestMethod.GET) 
	  public ResponseEntity<?> viewImage() {
		  byte[] imageData= imageService.viewImage();
		  return ResponseEntity.status(HttpStatus.OK)
				  .contentType(MediaType.valueOf("image/png"))
				  .body(imageData);
	  }
	  
	  /*@RequestMapping("/image")
		public ModelAndView viewData() {
		  byte[] imageData= imageService.viewImage();
			ModelAndView mav = new ModelAndView("image");
			mav.addObject("image",ResponseEntity.status(HttpStatus.OK)
					  .contentType(MediaType.valueOf("image/png"))
					  .body(imageData));
			return mav;
		}*/
}
