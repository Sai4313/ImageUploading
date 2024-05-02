package com.example.hiii;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {
	
	 	@Autowired
	    private ImageService imageService;

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
	        String imagePath = imageService.saveImage(file);
	        return ResponseEntity.ok().body(imagePath);
	    }

	    @GetMapping("/get")
	    public ResponseEntity<List<String>> getAllImagePaths() {
	        List<String> imagePaths = imageService.getAllImagePaths();
	        return ResponseEntity.ok().body(imagePaths);
	    }

	
}
