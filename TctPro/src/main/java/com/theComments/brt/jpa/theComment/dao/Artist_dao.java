package com.theComments.brt.jpa.theComment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Artist;

public interface Artist_dao extends JpaRepository<Artist, Long> {
	
	@Query("SELECT a FROM Artist a JOIN FETCH a.create c")
	public List<Artist> queryArtistExam();
	
	@Query(value = "SELECT a FROM Artist a WHERE art_name LIKE CONCAT('%',:art_name,'%')"
			,countQuery = "SELECT count(a) FROM Artist a WHERE art_name LIKE CONCAT('%',:art_name,'%')")
	public Page<Artist> artistSelectList(String art_name, Pageable pageable);

}
