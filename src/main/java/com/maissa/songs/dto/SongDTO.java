package com.maissa.songs.dto;

import java.util.Date;

import com.maissa.songs.entities.Album;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongDTO {
	private Long idSong;
	private String nomSong;
	private Double timeSong;
	private Date dateCreation;
	private Album album;
	private String nomAlb;
}
