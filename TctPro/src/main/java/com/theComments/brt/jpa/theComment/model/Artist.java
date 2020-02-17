package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;

import lombok.Getter;
import lombok.Setter;

@SqlResultSetMapping(name = "artistSearch", classes = {
		@ConstructorResult(targetClass = com.theComments.brt.jpa.dto.ArtistDto.class, 
				columns = {
				@ColumnResult(name = "artist_id", type = Long.class),
				@ColumnResult(name = "art_name", type = String.class),
				@ColumnResult(name = "see", type = Integer.class), 
				@ColumnResult(name = "listen", type = Integer.class),
				@ColumnResult(name = "doo", type = Integer.class), 
				@ColumnResult(name = "count", type = Long.class),
				@ColumnResult(name = "worksMax", type = LocalDateTime.class), }) })
@Entity
@Getter
@Setter
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long artist_id;

	String art_name;

	@OneToOne
	Eva_user eva_user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "artist")
	List<Create_art> create;

	LocalDateTime add_date;

	@OneToMany(mappedBy = "artist")
	List<ArtistSave> artistSave;
	
	@Column(columnDefinition = "integer default 0")
	Integer delYn;

}
