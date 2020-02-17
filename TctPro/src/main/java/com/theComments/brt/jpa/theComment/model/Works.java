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
	Long work_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="type2_id")
	Type2 type2;
	
	String subject;
	
	@OneToMany(mappedBy="works")
	Set<Evaluate> evaluate;
	
	@OneToMany(mappedBy="works")
	Set<WorksSave> worksSave;
	
	@OneToMany(mappedBy="works")
	Set<Create_art> create;
	
	@OneToMany(mappedBy="works")
	Set<FileSave> fileSave;
	
	int is_series;
	
	@Column(nullable=false)
	LocalDateTime create_date;
	LocalDateTime create_end_date2;
	
	@Column(columnDefinition = "integer default 0")
	Integer delYn;
	
}
