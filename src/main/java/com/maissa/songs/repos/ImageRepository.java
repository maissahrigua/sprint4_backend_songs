package com.maissa.songs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maissa.songs.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
	
}