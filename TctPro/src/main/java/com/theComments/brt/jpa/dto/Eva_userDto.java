package com.theComments.brt.jpa.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.Evaluate;
import com.theComments.brt.jpa.theComment.model.WorksSave;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eva_userDto {
	Long user_id;
	
	String nickname;
	
//	String user_login_id;
	String email;
	
	List<Evaluate> evaluateDto;
	
	List<WorksSave> worksSaveDto;
	
	ArtistDto artistDto;

	

}
