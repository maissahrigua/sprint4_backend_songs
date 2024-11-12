package com.maissa.songs.service;

import java.util.List;

import com.maissa.songs.entities.Song;
import com.maissa.songs.dto.SongDTO;
import com.maissa.songs.entities.Album;


public interface SongService {
	Song saveSong(Song s);
	Song updateSong(Song s);
	 void deleteSong(Song s);
     void deleteSongById(Long id);
     Song getSong(Long id);
	 List<Song> getAllSongs();
	 
	 List<Song> findByNomSong(String nom);
	 List<Song> findByNomSongContains(String nom);
	 List<Song> findByNomTime (String nom, Double time);
	 List<Song> findByAlbum (Album album);
	 List<Song> findByAlbumIdAlb(Long id);
	 List<Song> findByOrderByNomSongAsc();
	 List<Song> trierSongsNomsTime();
}
