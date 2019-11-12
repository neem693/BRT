package com.theComments.brt.jpa.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.theComments.brt.jpa.theComment.model.Create_art;
import com.theComments.brt.jpa.theComment.model.Evaluate;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.Type2;
import com.theComments.brt.jpa.theComment.model.WorksSave;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorksDto extends Page{

	Long work_id;
	Type2Dto type2;
	String subject;
	int is_series;
	LocalDateTime create_date;
	LocalDateTime create_end_date2;
	List<FileSaveDto> fileSaveDto;
	
	//need for works search return result
	List<ArtistDto> artistDtoList;
	// List<Evaluate> evaluate;
	//
	// @OneToMany(mappedBy="works")
	// List<WorksSave> worksSave;
	//
	// @OneToMany(mappedBy="works")
	// List<Create_art> create;
	//
	// @OneToMany(mappedBy="works")
	// List<FileSave> fileSave;

}
