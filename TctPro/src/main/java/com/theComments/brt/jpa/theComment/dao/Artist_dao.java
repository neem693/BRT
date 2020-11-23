package com.theComments.brt.jpa.theComment.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theComments.brt.jpa.theComment.model.Artist;

public interface Artist_dao extends JpaRepository<Artist, Long> {
	
	@Query("SELECT a FROM Artist a JOIN FETCH a.create c WHERE a.delYn = 0")
	public List<Artist> queryArtistExam();
	
	@Query(value = "SELECT a FROM Artist a WHERE art_name LIKE CONCAT('%',:art_name,'%') AND a.delYn = 0 "
			,countQuery = "SELECT count(a) FROM Artist a WHERE art_name LIKE CONCAT('%',:art_name,'%') AND a.delYn = 0")
	public Page<Artist> artistSelectList(String art_name, Pageable pageable);
	
	
	@Query(nativeQuery = true, value = 
			 " SELECT "
		   + "  a.artist_id, a.art_name, "
		   + "   (sum(CASE WHEN t1.TYPE1_ID = 1 THEN 1 ELSE 0 END)) see, "
		   + "   (sum(CASE WHEN t1.TYPE1_ID = 2 THEN 1 ELSE 0 END)) listen, "
		   + "   (sum(CASE WHEN t1.TYPE1_ID = 3 THEN 1 ELSE 0 END)) doo, "
		   + "  COUNT(t1.type1_id) count, "
		   + "  MAX(w.create_date) worksMax "  
		   + " FROM Artist a "   
		   + " INNER JOIN Create_art ca " 
		   + " ON a.artist_id = ca.artist_id " 
		   + " INNER JOIN Works w  "
		   + " ON ca.work_id = w.work_id "  
		   + " INNER JOIN Type2 t2  "
		   + " ON t2.type2_id = w.type2_id " 
		   + " INNER JOIN Type1 t1  "
		   + " ON t2.type1_id = t1.type1_id "
		   + " WHERE a.delYn = 0 "
		   + " AND w.delYn = 0 "
		   + " AND (:type1 IS NULL OR t1.type1_id = :type1 ) "
		   + " AND (:type2 IS NULL OR t2.type2_id = :type2 ) "
		   + " GROUP BY a.artist_id " 
		   ,countQuery = " SELECT count(a.artist_id) "
				   + " FROM Artist a "   
				   + " INNER JOIN Create_art ca " 
				   + " ON a.artist_id = ca.artist_id " 
				   + " inner join Works w  "
				   + " ON ca.work_id = w.work_id "  
				   + " INNER JOIN Type2 t2  "
				   + " ON t2.type2_id = w.type2_id " 
				   + " INNER JOIN Type1 t1  "
				   + " ON t2.type1_id = t1.type1_id "
				   + " WHERE a.delYn = 0 "
				   + " AND (:type1 IS NULL OR t1.type1_id = :type1 ) "
				   + " AND (:type2 IS NULL OR t2.type2_id = :type2 ) "
				   + " AND w.delYn = 0 "
				   + " GROUP BY a.artist_id " )
	public Page<Map<String,Object>> search(Long type1, Long type2,Pageable pageable);


}
