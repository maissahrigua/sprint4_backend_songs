package com.maissa.songs.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlb;
	private String nomAlb;
	private String descriptionAlb;
	@JsonIgnore
	@OneToMany(mappedBy = "album")
	private List<Song> songs;

	/*public Album() {
		super();
	}*/
	
	public Album(String nomAlb, String descriptionAlb, List<Song> songs)
	{
		super();
		this.nomAlb = nomAlb;
		this.descriptionAlb = descriptionAlb;
		this.songs = songs;
	}

	public Long getIdAlb() {
		return idAlb;
	}
	
	public void setIdAlb(Long idAlb) {
		this.idAlb = idAlb;
	}
	
	public String getNomAlb() {
		return nomAlb;
	}
	
	public void setNomAlb(String nomAlb) {
		this.nomAlb = nomAlb;
	}
	
	public String getDescriptionAlb() {
		return descriptionAlb;
	}
	
	public void setDescriptionAlb(String descriptionAlb) {
		this.descriptionAlb = descriptionAlb;
	}
	
	public List<Song> getSongs() {
		return songs;
	}
	
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
