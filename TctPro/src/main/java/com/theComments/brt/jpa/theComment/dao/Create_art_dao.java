package com.theComments.brt.jpa.theComment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Create_art;

public interface Create_art_dao extends JpaRepository<Create_art, Long>{

	@Query("SELECT c FROM Create_art c JOIN c.artist a JOIN c.works w WHERE a.artist_id = :artist_id AND w.work_id = :work_id")
	List<Create_art> findArtistAndWorks(Long artist_id, Long work_id);

}
