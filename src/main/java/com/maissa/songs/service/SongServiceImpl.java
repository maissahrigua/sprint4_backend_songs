package com.maissa.songs.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maissa.songs.dto.SongDTO;
import com.maissa.songs.entities.Album;
import com.maissa.songs.entities.Song;
import com.maissa.songs.repos.ImageRepository;
import com.maissa.songs.repos.SongRepository;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	SongRepository songRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	
	
	@Override
	public Song saveSong(Song s) {
		return songRepository.save(s);
		
	}
	
	@Override
	public Song updateSong(Song s) {
		//Long oldSonImageId = this.getSong(s.getIdSong()).getImage().getIdImage();
		//Long newSonImageId = s.getImage().getIdImage();
		Song sonUpdated = songRepository.save(s);
		//if (oldSonImageId != newSonImageId) // si l'image a été modifiée
			//imageRepository.deleteById(oldSonImageId);
		return sonUpdated;
	}

	@Override
	public void deleteSong(Song s) {
		songRepository.delete(s);

	}

	@Override
	public void deleteSongById(Long id) {
		Song s = getSong(id);
		// suuprimer l'image avant de supprimer le song
		try {
			Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + s.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		songRepository.deleteById(id);
	}

	@Override
	public Song getSong(Long id) {
		return  songRepository.findById(id).get();
	
	}

	@Override
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}
	
    @Override
	public List<Song> findByNomSong(String nom) {
		return songRepository.findByNomSong(nom);
	}

	@Override
	public List<Song> findByNomSongContains(String nom) {
		return songRepository.findByNomSongContains(nom);
	}

	@Override
	public List<Song> findByNomTime(String nom, Double time) {
		return songRepository.findByNomSong(nom, time);
	}
	
	@Override
	public List<Song> findByAlbum(Album album) {
		return songRepository.findByAlbum(album);
	}

	@Override
	public List<Song> findByAlbumIdAlb(Long id) {
		return songRepository.findByAlbumIdAlb(id);
	}

	@Override
	public List<Song> findByOrderByNomSongAsc() {
		return songRepository.findByOrderByNomSongAsc();
	}

	@Override
	public List<Song> trierSongsNomsTime() {
		return songRepository.trierSongsNomsTime();
	}

}
