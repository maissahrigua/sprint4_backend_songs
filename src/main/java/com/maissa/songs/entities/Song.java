package com.maissa.songs.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSong;
	private String nomSong;
	private Double timeSong;
	private Date dateCreation;
		
	@ManyToOne
	private Album album;
	
	private String imagePath;

	/*
	 * @OneToOne private Image image;
	 */
	
	@OneToMany (mappedBy = "song")
	 private List<Image> images;

	public Song() {
		super();
	}
	
	public Song(String nomSong, Double timeSong, Date dateCreation) {
		super();
		this.nomSong = nomSong;
		this.timeSong = timeSong;
		this.dateCreation = dateCreation;
	}

	public Long getIdSong() {
		return idSong;
	}
	
	public void setIdSong(Long idSong) {
		this.idSong = idSong;
	}
	
	public String getNomSong() {
		return nomSong;
	}
	
	public void setNomSong(String nomSong) {
		this.nomSong = nomSong;
	}
	
	public Double getTimeSong() {
		return timeSong;
	}
	
	public void setTimeSong(Double timeSong) {
		this.timeSong = timeSong;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Song [idSong=" + idSong + ", nomSong=" + nomSong + ", timeSong=" + timeSong
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
