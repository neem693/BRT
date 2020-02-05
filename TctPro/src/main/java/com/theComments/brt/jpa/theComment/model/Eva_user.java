package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
	
	LocalDateTime join_date;
	
	LocalDateTime login_date;
	
	@Transient
	String sns_type;
	
	@Transient
	String access_token;
	
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
