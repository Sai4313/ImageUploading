package com.example.hiii;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	
	private String uploadPath="C:/Users/SP-SAIKRISHNA/microservices/Imageuploading/src/assets/images";

    @Autowired
    private Imagerepo imageRepository;

    public String saveImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadPath, fileName);
        Files.write(filePath, file.getBytes());

        // Save the path only in database
        Image image = new Image();
        image.setFileName(fileName);
        imageRepository.save(image);

        return fileName;
    }

    public List<String> getAllImagePaths() {
        List<Image> images = imageRepository.findAll();
        return images.stream().map(Image::getFileName).collect(Collectors.toList());
    }
}
