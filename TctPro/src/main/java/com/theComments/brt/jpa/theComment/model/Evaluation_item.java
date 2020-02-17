package com.theComments.brt.jpa.theComment.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SqlResultSetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;
import lombok.Setter;

@NamedEntityGraph(
		name = "evaluation_item.listMain",
		attributeNodes = {
				@NamedAttributeNode(value = "evaluate",subgraph = "item_eval"),
				@NamedAttributeNode(value = "fileSave")
		},
		subgraphs = {
			@NamedSubgraph(
					name="item_eval",
					attributeNodes = {
					@NamedAttributeNode(value = "works", subgraph = "eval_works")
			}),
			@NamedSubgraph(
					name="eval_works",
					attributeNodes = {
					@NamedAttributeNode(value = "type2", subgraph = "type2_type1"),
					@NamedAttributeNode(value = "create", subgraph = "create_artist"),
					@NamedAttributeNode("fileSave"),
					
			}),
			@NamedSubgraph(
					name="create_artist",
					attributeNodes = {
					@NamedAttributeNode(value = "artist")
					}),
			@NamedSubgraph(
					name ="type2_type1",
					attributeNodes = {
					@NamedAttributeNode("type1")
			})
		})
@SqlResultSetMapping(
		name = "selectSubjectMatterGroup",
		classes = {
				@ConstructorResult(
						targetClass = com.theComments.brt.jpa.dto.Evaluation_itemDto.class,
						columns = {
							@ColumnResult(name="subjectMatter",type=String.class),
							@ColumnResult(name="yellow",type=Integer.class),
							@ColumnResult(name="blue",type=Integer.class),
							@ColumnResult(name="gray",type=Integer.class),
							@ColumnResult(name="black",type=Integer.class)
						})
		})
@Entity
@Getter
@Setter
public class Evaluation_item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long eval_item_id;
	
	String subjectMatter;
	
	String ev_text1;
	String ev_text2;
	@Column(nullable = false)
	Integer ev_value;
	
	String donation;
	
	@OneToMany(mappedBy = "evaluation_item")
	List<Evaluate> evaluate;
	
	@OneToMany(mappedBy = "eval_item")
	Set<FileSave> fileSave;

	@Column(columnDefinition = "integer default 0")
	Integer delYn;
	

}
