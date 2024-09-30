package com.maissa.songs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.maissa.songs.entities.Album;
import com.maissa.songs.entities.Song;
import com.maissa.songs.repos.SongRepository;

@SpringBootTest
class SongsApplicationTests {

	@Autowired
	private SongRepository songRepository;
	@Test
	public void testCreateSong() {
		Song son = new Song("Lover",3.01,new Date());
		songRepository.save(son);
	}
	
	@Test
	public void testFindSong()
	{
		Song s = songRepository.findById(1L).get();
		System.out.println(s);
	}
	
	@Test
	public void testUpdateSong()
	{
		Song s = songRepository.findById(1L).get();
		s.setTimeSong(1000.0);
		songRepository.save(s);
	}
	
	@Test
	public void testDeleteSong()
	{
		songRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousSongs()
	{
		List<Song> sons = songRepository.findAll();
		for (Song s : sons)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testFindByNomSong()
	{
		List<Song> sons = songRepository.findByNomSong("All too well");
		for (Song s : sons)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testFindByNomSongContains ()
	{
		List<Song> sons=songRepository.findByNomSongContains("All");
		for (Song s : sons)
		{
			System.out.println(s);
		} 
	}
	
	/*@Test
	public void testfindByNomPrix()
	{
		List<Song> sons = songRepository.findByNomAndTime("Illicit Affairs", 1000.0);
		for (Song s : sons)
		{
			System.out.println(s);
		}
	}*/
	
	@Test
	public void testfindByAlbum()
	{
		Album alb = new Album();
		alb.setIdAlb(1L);
		List<Song> sons = songRepository.findByAlbum(alb);
		for (Song s : sons)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void findByAlbumIdAlb()
	{
		List<Song> sons = songRepository.findByAlbumIdAlb(2L);
		for (Song s : sons)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testfindByOrderByNomSongAsc()
	{
		List<Song> sons = songRepository.findByOrderByNomSongAsc();
		for (Song s : sons)
		{
			System.out.println(s);
		}
	}
	
	@Test
	public void testTrierSongsNomsTime()
	{
		List<Song> sons = songRepository.trierSongsNomsTime();
		for (Song s : sons)
		{
			System.out.println(s);
		}
	}

}
