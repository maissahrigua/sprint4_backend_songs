package com.maissa.songs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.maissa.songs.entities.Album;


@RepositoryRestResource(path = "alb")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface AlbumRepository extends JpaRepository<Album, Long>{

}
