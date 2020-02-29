package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ArtistSave {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long artist_save_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Eva_user eva_user;
	
	LocalDateTime save_date;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	Artist artist;
	
	

}
