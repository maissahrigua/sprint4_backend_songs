package com.maissa.songs.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.maissa.songs.entities.Image;
import com.maissa.songs.entities.Song;
import com.maissa.songs.service.ImageService;
import com.maissa.songs.service.SongService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;

	@Autowired
	SongService songService;
	
	/*
	 * @RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST) public
	 * void uploadImageFS(@RequestParam("image") MultipartFile
	 * file, @PathVariable("id") Long id) throws IOException { Song s =
	 * songService.getSong(id); s.setImagePath(id + ".jpg");
	 * 
	 * Files.write(Paths.get(System.getProperty("user.home") + "/images/" +
	 * s.getImagePath()), file.getBytes()); songService.saveSong(s); }
	 * 
	 * @RequestMapping(value = "/loadfromFS/{id}" , method = RequestMethod.GET,
	 * produces = MediaType.IMAGE_JPEG_VALUE) public byte[]
	 * getImageFS(@PathVariable("id") Long id) throws IOException {
	 * 
	 * Song s = songService.getSong(id); return
	 * Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+s.
	 * getImagePath())); }
	 */
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
	
	@PostMapping(value = "/uplaodImageSon/{idSon}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idSon") Long idSon)
			throws IOException {
		return imageService.uplaodImageSon(file, idSon);
	}

	@RequestMapping(value = "/getImagesSon/{idSon}", method = RequestMethod.GET)
	public List<Image> getImagesSon(@PathVariable("idSon") Long idSon) throws IOException {
		return imageService.getImagesParSon(idSon);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
}
