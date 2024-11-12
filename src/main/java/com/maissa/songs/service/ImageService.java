package com.maissa.songs.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.maissa.songs.entities.Image;

public interface ImageService {
	
	Image uplaodImage(MultipartFile file) throws IOException;
	Image getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id) ;
	
	Image uplaodImageSon(MultipartFile file,Long idSon) throws IOException;
	List<Image> getImagesParSon(Long sonId);
}
