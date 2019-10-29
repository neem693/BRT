package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long artist_id;
	
	String art_name;
	
	@OneToOne
	Eva_user eva_user;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "artist")
	List<Create_art> create;
	
	LocalDateTime add_date;
	
	@OneToMany(mappedBy = "artist")
	List<ArtistSave> artistSave;

	public Long getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(Long artist_id) {
		this.artist_id = artist_id;
	}

	public String getArt_name() {
		return art_name;
	}

	public void setArt_name(String art_name) {
		this.art_name = art_name;
	}

	public Eva_user getEva_user() {
		return eva_user;
	}

	public void setEva_user(Eva_user eva_user) {
		this.eva_user = eva_user;
	}

	public List<Create_art> getCreate() {
		return create;
	}

	public void setCreate(List<Create_art> create) {
		this.create = create;
	}

	public LocalDateTime getAdd_date() {
		return add_date;
	}

	public void setAdd_date(LocalDateTime add_date) {
		this.add_date = add_date;
	}

	public List<ArtistSave> getArtistSave() {
		return artistSave;
	}

	public void setArtistSave(List<ArtistSave> artistSave) {
		this.artistSave = artistSave;
	}
	
	
	
	
	
	
	
}
