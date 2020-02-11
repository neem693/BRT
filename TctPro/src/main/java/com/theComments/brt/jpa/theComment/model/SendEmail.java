package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedEntityGraph(
		name = "loadingEmail_template",
		attributeNodes = {
				@NamedAttributeNode("email_template")
		})
public class SendEmail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long send_email_id;
	
	/**
	 * 0: 보내지 않음
	 * 1: 보내는 중
	 * 2: 보내기 완료
	 */
	Integer status;
	
	@Column(columnDefinition = "TEXT")
	String send_text;
	
	@Column(length = 512)
	String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_template_id")
	Email_template email_template;

	String subject;
	
	LocalDateTime saveTime;

}
