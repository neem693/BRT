package com.theComments.brt.jpa.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.theComments.brt.jpa.theComment.model.Create_art;

import lombok.Data;

@Data
public class ArtistDto extends Page{
	
	Long artist_id;
	String art_name;
	
	Eva_userDto eva_userDto;
	
	List<Create_art> createDto;
	
	LocalDateTime add_date;
	
	Integer see;

	Integer listen;
	Integer doo;
	Long count;
	LocalDateTime worksMax;
	
	
	
	
	public ArtistDto(Long artist_id, String art_name, Integer see,  Integer listen, Integer doo, Long count,
			LocalDateTime worksMax) {
		super();
		this.artist_id = artist_id;
		this.art_name = art_name;
		this.see = see;
		this.listen = listen;
		this.doo = doo;
		this.count = count;
		this.worksMax = worksMax;
	}




	public ArtistDto() {
		super();
	}
	
	

}
