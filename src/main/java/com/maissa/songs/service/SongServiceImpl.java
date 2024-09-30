package com.maissa.songs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maissa.songs.dto.SongDTO;
import com.maissa.songs.entities.Album;
import com.maissa.songs.entities.Song;
import com.maissa.songs.repos.SongRepository;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	SongRepository songRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public SongDTO saveSong(SongDTO s) {
		return convertEntityToDto( songRepository.save(convertDtoToEntity(s)));
	}

	@Override
	public SongDTO updateSong(SongDTO s) {
	 return convertEntityToDto(songRepository.save(convertDtoToEntity(s)));
	}


	@Override
	public void deleteSong(Song s) {
		songRepository.delete(s);	
	}

	@Override
	public void deleteSongById(Long id) {
		songRepository.deleteById(id);
	}

	@Override
	public SongDTO getSong(Long id) {
		return convertEntityToDto( songRepository.findById(id).get());
	}

	@Override
	public List<SongDTO> getAllSongs() {
		return songRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
				//OU BIEN
				/*List<Song> sons = songRepository.findAll();
				List<SongDTO> listsonDto = new ArrayList<>(sons.size());
				for (Song s : sons)
				listsonDto.add(convertEntityToDto(s));
				return listsonDto;*/
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

	@Override
	public SongDTO convertEntityToDto(Song song) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		SongDTO songDto = modelMapper.map(song, SongDTO.class);
		return songDto; 
		 
		/*SongDTO songDTO = new SongDTO();
		 songDTO.setIdSong(song.getIdSong());
		 songDTO.setNomsong(song.getNomSong());
		 songDTO.setTimesong(song.getTimeSong());
		 songDTO.setDateCreation(song.getDateCreation());
		 songDTO.setAlbum(song.getAlbum());
		 return songDTO;*/
	
		 /*return SongDTO.builder()
		.idSong(song.getIdSong())
		.nomSong(song.getNomSong())
		.timeSong(song.getTimeSong())
		.dateCreation(song.getDateCreation())
		//.nomAlb(song.getAlbum().getNomAlb())
		.album(song.getAlbum())
		.build();*/
	}

	@Override
	public Song convertDtoToEntity(SongDTO songDto) {
		Song song = new Song();
		song = modelMapper.map(songDto, Song.class);
		return song;
		
		/*Song song = new Song();
		song.setIdSong(songDto.getIdSong());
		song.setNomSong(songDto.getNomSong());
		song.setTimeSong(songDto.getTimeSong());
		song.setDateCreation(songDto.getDateCreation());
		song.setAlbum(songDto.getAlbum());
		return song;*/
	}

}
