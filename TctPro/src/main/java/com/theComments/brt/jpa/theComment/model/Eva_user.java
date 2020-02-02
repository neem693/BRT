package com.theComments.brt.jpa.theComment.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	
	@OneToMany(mappedBy = "eva_user")
	List<Sns_user> sns_user;
	
	
}
