package com.maissa.songs.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.maissa.songs.entities.Album;
import com.maissa.songs.entities.Song;

@RepositoryRestResource(path = "rest")
public interface SongRepository extends JpaRepository<Song, Long> {
	List<Song> findByNomSong(String nom);
	List<Song> findByNomSongContains(String nom);   
	
	@Query("select s from Song s where s.nomSong like %:nom and s.timeSong > :time")
	List<Song> findByNomSong (@Param("nom") String nom,@Param("time") Double time);
    
	@Query("select s from Song s where s.album = ?1")
	List<Song> findByAlbum (Album album);
	
	List<Song> findByAlbumIdAlb(Long id);
	
	List<Song> findByOrderByNomSongAsc();
	
	@Query("select s from Song s order by s.nomSong ASC, s.timeSong DESC")
	List<Song> trierSongsNomsTime ();
	//List<Song> findByNomAndTime(String nom, double time);

	              




}