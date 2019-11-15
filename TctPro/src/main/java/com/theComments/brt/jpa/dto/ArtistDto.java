package com.theComments.brt.jpa.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.theComments.brt.jpa.theComment.model.Create_art;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistDto extends Page{
	
	Long artist_id;
	String art_name;
	
	Eva_userDto eva_userDto;
	
	List<Create_art> createDto;
	
	LocalDateTime add_date;
	
	Integer see;
	Integer doo;
	Integer listen;
	Long count;
	LocalDateTime worksMax;
	
	
	
	
	public ArtistDto(Long artist_id, String art_name, Integer see, Integer doo, Integer listen, Long count,
			LocalDateTime worksMax) {
		super();
		this.artist_id = artist_id;
		this.art_name = art_name;
		this.see = see;
		this.doo = doo;
		this.listen = listen;
		this.count = count;
		this.worksMax = worksMax;
	}




	public ArtistDto() {
		super();
	}
	
	

}
