package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.util.Date;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonView;
import com.theComments.brt.jpa.dto.Page;
import com.theComments.brt.jpa.dto.PageAndSort;
import com.theComments.brt.jsonView.BRTJsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Data
@EqualsAndHashCode(exclude = {"create","artistSave","eva_user"})
@ToString(callSuper = false,exclude = {"create","artistSave","eva_user"})
public class Artist extends PageAndSort {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BRTJsonView.Artist.class)
	Long artist_id;
	
	@Column
	@JsonView(BRTJsonView.ArtistCommon.class)
	String art_name;

	@OneToOne
	@JsonView(BRTJsonView.Artist.class)
	Eva_user eva_user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "artist")
	@JsonView(BRTJsonView.Artist.class)
	List<Create_art> create;

	@Column
	@JsonView(BRTJsonView.ArtistCommon.class)
	LocalDateTime add_date;

	@OneToMany(mappedBy = "artist")
	@JsonView(BRTJsonView.Artist.class)
	List<ArtistSave> artistSave;
	
	@Column
	@JsonView(BRTJsonView.Artist.class)
	Integer delYn = 0;
	
	@Transient
	@JsonView(BRTJsonView.Artist.class)
	Integer see;
	

	@Transient
	@JsonView(BRTJsonView.Artist.class)
	Integer listen;
	

	@Transient
	@JsonView(BRTJsonView.Artist.class)
	Integer doo;
	

	@Transient
	@JsonView(BRTJsonView.Artist.class)
	Integer count;
	

	@Transient
	@JsonView(BRTJsonView.Artist.class)
	LocalDateTime worksMax;

}
