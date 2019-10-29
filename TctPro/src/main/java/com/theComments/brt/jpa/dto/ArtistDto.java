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

}
