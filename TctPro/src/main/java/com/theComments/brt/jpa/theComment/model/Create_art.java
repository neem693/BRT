package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Create_art{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long create_id;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	Artist artist;	
	
	@ManyToOne
	@JoinColumn(name="work_id")
	Works works;
	

	
	
	public Long getCreate_id() {
		return create_id;
	}
	public void setCreate_id(Long create_id) {
		this.create_id = create_id;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Works getWorks() {
		return works;
	}
	public void setWorks(Works works) {
		this.works = works;
	}
	
	
	
	
	
	
	

}
