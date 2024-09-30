package com.maissa.songs.service;

import java.util.List;

import com.maissa.songs.entities.Song;
import com.maissa.songs.dto.SongDTO;
import com.maissa.songs.entities.Album;


public interface SongService {
	SongDTO saveSong(SongDTO s);
	SongDTO getSong(Long id);
	List<SongDTO> getAllSongs();
	
	SongDTO updateSong(SongDTO s);
	void deleteSong(Song s);
	void deleteSongById(Long id);
	List<Song> findByNomSong(String nom);
	List<Song> findByNomSongContains(String nom);
	List<Song> findByNomTime (String nom, Double time);
	List<Song> findByAlbum (Album album);
	List<Song> findByAlbumIdAlb(Long id);
	List<Song> findByOrderByNomSongAsc();
	List<Song> trierSongsNomsTime();
	SongDTO convertEntityToDto (Song song);
	Song convertDtoToEntity(SongDTO songDto);
}
