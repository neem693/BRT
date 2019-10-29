package com.theComments.brt.jpa.theComment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Eva_user {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long user_id;
	
	@Column(unique=true,nullable=false)
	String nickname;
	
	@Column(unique=true,nullable=false)
	String user_login_id;
	
	String password;
	
	@Column(unique=true,nullable=false)
	String email;
	
	@OneToMany(mappedBy = "eva_user")
	List<Evaluate> evaluate;
	
	@OneToMany(mappedBy = "eva_user")
	List<WorksSave> worksSave;
	
	@OneToMany(mappedBy = "eva_user")
	List<ArtistSave> artistSave;
	
	@OneToOne(mappedBy = "eva_user")
	Artist artist;

	
	
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUser_login_id() {
		return user_login_id;
	}

	public void setUser_login_id(String user_login_id) {
		this.user_login_id = user_login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Evaluate> getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(List<Evaluate> evaluate) {
		this.evaluate = evaluate;
	}

	public List<WorksSave> getWorksSave() {
		return worksSave;
	}

	public void setWorksSave(List<WorksSave> worksSave) {
		this.worksSave = worksSave;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<ArtistSave> getArtistSave() {
		return artistSave;
	}

	public void setArtistSave(List<ArtistSave> artistSave) {
		this.artistSave = artistSave;
	}
	
	
	
	

	
	
	
	
	
}
