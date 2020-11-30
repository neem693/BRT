package com.theComments.brt.jpa.theComment.model;

import java.time.LocalDateTime;
import java.util.Set;

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
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.theComments.brt.jsonView.BRTJsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedEntityGraph(
		name = "findByIdDetail_graph",
		attributeNodes = {
				@NamedAttributeNode("fileSave"),
				@NamedAttributeNode(value = "create",subgraph = "create_artist"),
				@NamedAttributeNode(value = "type2", subgraph = "type2_type1")
		},
		subgraphs = {
			@NamedSubgraph(
					name="create_artist",
					attributeNodes = {
					@NamedAttributeNode("artist")
			}),
			@NamedSubgraph(
					name ="type2_type1",
					attributeNodes = {
					@NamedAttributeNode("type1")
			})
		})
@NamedEntityGraph(
		name = "SelectWorksByArtist",
				attributeNodes = {
						@NamedAttributeNode("fileSave"),
						@NamedAttributeNode("type2"),
		})
@Getter
@Setter
public class Works {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonView(BRTJsonView.WorksCommon.class)
	Long work_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="type2_id")
	@JsonView(BRTJsonView.Works.class)
	Type2 type2;
	
	@JsonView(BRTJsonView.WorksCommon.class)
	String subject;
	
	
	@OneToMany(mappedBy="works")
	@JsonView(BRTJsonView.Works.class)
	Set<Evaluate> evaluate;
	
	@OneToMany(mappedBy="works")
	@JsonView(BRTJsonView.Works.class)
	Set<WorksSave> worksSave;
	
	@OneToMany(mappedBy="works")
	@JsonView(BRTJsonView.WorksCommon.class)
	Set<Create_art> create;
	
	@OneToMany(mappedBy="works")
	@JsonView(BRTJsonView.WorksCommon.class)
	Set<FileSave> fileSave;

	@JsonView(BRTJsonView.WorksCommon.class)
	int is_series;
	
	@Column(nullable=false)
	@JsonView(BRTJsonView.WorksCommon.class)
	LocalDateTime create_date;

	@JsonView(BRTJsonView.WorksCommon.class)
	LocalDateTime create_end_date2;
	
	@Column
	@JsonView(BRTJsonView.Works.class)
	Integer delYn = 0;
	
}
