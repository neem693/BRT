package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Create_art implements Comparable<Create_art>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long create_id;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	Artist artist;	
	
	@ManyToOne
	@JoinColumn(name="work_id")
	Works works;
	
	LocalDateTime save_date;
	
	Integer artist_rank;
	

	
	
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
	public LocalDateTime getSave_date() {
		return save_date;
	}
	public void setSave_date(LocalDateTime save_date) {
		this.save_date = save_date;
	}
	public Integer getArtist_rank() {
		return artist_rank;
	}
	public void setArtist_rank(Integer artist_rank) {
		this.artist_rank = artist_rank;
	}
	
	@Override
	public int compareTo(Create_art o) {
		// TODO Auto-generated method stub
		
		return this.getSave_date().compareTo(o.getSave_date());
	}

	
	
	
	
	
	
	
	
	

}
