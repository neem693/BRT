package com.theComments.brt.jpa.theComment.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.theComments.brt.constFile.PageConst;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.jpa.dto.OrderForSearch;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.theComment.model.Artist_;
import com.theComments.brt.jpa.theComment.model.QArtist;

/***
 * 
 * @author UIO dynamic query or custom query for native query .. etc
 */
@Component
public class ArtistDynamicQueryDao {

	@Autowired
	@Qualifier("emFac1")
	EntityManagerFactory entityManagerFactory;

	public Map<String,Object> searchArtistDynamic(
			ArtistDto artistDto, 
			Type1Dto type1Dto, 
			Type2Dto type2Dto,
			OrderForSearch orderForSearch) {
		// TODO Auto-generated method stub
		
		EntityManager em = entityManagerFactory.createEntityManager();
		String select_str =
				"SELECT \r\n" + 
				"a.artist_id,\r\n" + 
				"a.art_name, \r\n" + 
				"(sum(CASE  \r\n" + 
				"             WHEN t1.TYPE1_ID = 1 THEN 1 \r\n" + 
				"              ELSE 0 \r\n" + 
				"END)) see,\r\n" + 
				"(sum(CASE  \r\n" + 
				"             WHEN t1.TYPE1_ID = 2 THEN 1 \r\n" + 
				"              ELSE 0 \r\n" + 
				"END)) listen,\r\n" + 
				"(sum(CASE  \r\n" + 
				"             WHEN t1.TYPE1_ID = 3 THEN 1 \r\n" + 
				"              ELSE 0 \r\n" + 
				"END)) doo,\r\n" + 
				"count(t1.type1_id) count,\r\n" + 
				"max(w.create_date) worksMax\r\n";
		String query_str = 
				"FROM Artist a \r\n" + 
				"inner join Create_art ca\r\n" + 
				"on a.artist_id = ca.artist_id\r\n" + 
				"inner join Works w\r\n" + 
				"on ca.work_id = w.work_id\r\n" + 
				"inner join Type2 t2\r\n" + 
				"on t2.type2_id = w.type2_id\r\n" + 
				"inner join Type1 t1\r\n" + 
				"on t2.type1_id = t1.type1_id\r\n";
		
		if(type1Dto.getType1_id() != 0 || artistDto.getSearchText() != "" ) {
			
			query_str += "where 1=1 ";
			
		}
		
		if(type1Dto.getType1_id() != 0) {
			
			query_str +=" and t1.type1_id = " + type1Dto.getType1_id();
			if(type2Dto.getType2_id() != 0) {
				query_str +=" and t2.type2_id = "+ type2Dto.getType2_id();
			}
		}
		
		if(artistDto.getSearchText() != "") {
			query_str +="and a.art_name like "+ "'%" + artistDto.getSearchText() + "%'";
		}
		
		query_str+=" group by a.artist_id";
		
		String order = " order by";
		if(orderForSearch.getOrder() ==0) {
			order += " worksMax";
			
			if(orderForSearch.getOrder2() ==0) {
				order += " desc,count desc";
			}else if(orderForSearch.getOrder2() == 1) {
				order += " asc,count desc";
			}
			
		}else if(orderForSearch.getOrder() == 1) {
			
			order += " count";
			
			if(orderForSearch.getOrder2() ==0) {
				order += " desc,worksMax desc";
			}else if(orderForSearch.getOrder2() == 1) {
				order += " asc,worksMax desc";
			}
		}
		
		int pageNum =artistDto.getPageNum()-1;
		int pageSize = PageConst.PAGE.PAGE_SIZE;
		String limit = " limit "+pageNum + "," + pageSize; 
		
		System.out.println(select_str + query_str + order+ limit);
		
		Query query = em.createNativeQuery(select_str + query_str + order + limit,"artistSearch");
		List<ArtistDto> data = query.getResultList();
		Query queryCount = em.createNativeQuery("SELECT COUNT(*)" + query_str);
		BigInteger totalCount;
		try {
			totalCount = (BigInteger)queryCount.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			totalCount =new BigInteger("0");
		}
		em.close();
		
		Map<String,Object> returnData = new HashMap<String, Object>();
		returnData.put("data", data);
		returnData.put("totalSize", totalCount.longValue());

		return returnData;
	}

}
