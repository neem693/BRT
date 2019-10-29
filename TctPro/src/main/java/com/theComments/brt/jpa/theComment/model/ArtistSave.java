package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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

	public Long getArtist_save_id() {
		return artist_save_id;
	}

	public void setArtist_save_id(Long artist_save_id) {
		this.artist_save_id = artist_save_id;
	}

	public Eva_user getEva_user() {
		return eva_user;
	}

	public void setEva_user(Eva_user eva_user) {
		this.eva_user = eva_user;
	}

	public LocalDateTime getSave_date() {
		return save_date;
	}

	public void setSave_date(LocalDateTime save_date) {
		this.save_date = save_date;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	

}
