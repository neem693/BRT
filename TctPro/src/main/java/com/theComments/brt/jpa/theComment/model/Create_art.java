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

import com.fasterxml.jackson.annotation.JsonView;
import com.theComments.brt.jsonView.BRTJsonView;

import lombok.Data;

@Entity
@Data
public class Create_art implements Comparable<Create_art>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonView(BRTJsonView.Create.class)
	Long create_id;
	
	@ManyToOne
	@JoinColumn(name="artist_id")
	@JsonView(BRTJsonView.CreateArtist.class)
	Artist artist;	
	
	@ManyToOne
	@JoinColumn(name="work_id")
	@JsonView(BRTJsonView.CreateWorks.class)
	Works works;
	
	@JsonView(BRTJsonView.CreateCommon.class)
	LocalDateTime save_date;
	
	@JsonView(BRTJsonView.CreateCommon.class)
	Integer rep;
	
	@Deprecated
	@JsonView(BRTJsonView.CreateCommon.class)
	Integer artist_rank;
	
	@Override
	public int compareTo(Create_art o) {
		// TODO Auto-generated method stub
		
		if(this.getRep() >o.getRep()) {
			return -1;
		}else if(this.getRep() <o.getRep()) {
			return 1;
		}else {
			return 0;
		}
	}

	
	
	
	
	
	
	
	
	

}
