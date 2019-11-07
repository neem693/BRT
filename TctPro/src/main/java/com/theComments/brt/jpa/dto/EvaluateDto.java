package com.theComments.brt.jpa.dto;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.Evaluation_item;
import com.theComments.brt.jpa.theComment.model.Works;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EvaluateDto {
	

	Long eval_id;
	Eva_userDto eva_user;
	Evaluation_itemDto evaluation_item;
	WorksDto works;
	LocalDateTime eval_date;

}
