package com.maissa.songs.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maissa.songs.dto.SongDTO;
import com.maissa.songs.entities.Song;
import com.maissa.songs.service.SongService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SongRESTController {
	@Autowired
	SongService songService;
	
	@RequestMapping(path="all",method =RequestMethod.GET)
	public List<Song> getAllSongs() {
		return songService.getAllSongs();
	 } 		
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	//@GetMapping("/getbyid/{id}")
	public Song getSongById(@PathVariable("id") Long id) {	
		return songService.getSong(id);
    }
	
	@RequestMapping(value="/addson",method = RequestMethod.POST)
	//@PostMapping("/addsond")
	public Song createSong(@RequestBody Song song) {
		System.out.println(song);
		return songService.saveSong(song);
	}

	@RequestMapping(value="/updateson",method = RequestMethod.PUT)
	//@PutMapping("/updateson")
	public Song updateSong(@RequestBody Song song) {
		return songService.updateSong(song);
	}

	@RequestMapping(value="/delson/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("/delson/{id}")
	public void deleteSong(@PathVariable("id") Long id)
	{
		songService.deleteSongById(id);
	}
	
	@RequestMapping(value="/sonsalb/{idAlb}",method = RequestMethod.GET)
	public List<Song> getSongsByAlbId(@PathVariable("idAlb") Long idAlb) {
		return songService.findByAlbumIdAlb(idAlb);
	 }
}