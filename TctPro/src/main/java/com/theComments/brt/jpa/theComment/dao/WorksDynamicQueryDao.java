package com.theComments.brt.jpa.theComment.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.theComments.brt.constFile.PageConst.PAGE;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.jpa.dto.FileSaveDto;
import com.theComments.brt.jpa.dto.OrderForSearch;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.Create_art;
import com.theComments.brt.jpa.theComment.model.Create_art_;
import com.theComments.brt.jpa.theComment.model.Evaluate;
import com.theComments.brt.jpa.theComment.model.Evaluate_;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.FileSave_;
import com.theComments.brt.jpa.theComment.model.Type1;
import com.theComments.brt.jpa.theComment.model.Type1_;
import com.theComments.brt.jpa.theComment.model.Type2;
import com.theComments.brt.jpa.theComment.model.Type2_;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.jpa.theComment.model.Works_;
import com.theComments.brt.util.ResultMap;

/***
 * 
 * @author UIO dynamic query or custom query for native query .. etc
 */
@Component
public class WorksDynamicQueryDao {

	@Autowired
	@Qualifier("emFac1")
	EntityManagerFactory entityManagerFactory;

	public ResultMap SelectWorksDynamicForDialog(WorksDto worksDto, Type2Dto type2, Type1Dto type1) {
		EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Works> cq = cb.createQuery(Works.class);
		Root<Works> worksRoot = cq.from(Works.class);

		Join<Works, Type2> type2Root = worksRoot.join(Works_.TYPE2, JoinType.INNER);
		Join<Type2, Type1> type1Root = type2Root.join(Type2_.TYPE1, JoinType.INNER);

		Long type1_id = type1.getType1_id();
		Long type2_id = type2.getType2_id();

		List<Predicate> predicate_list = new ArrayList<Predicate>();

		if (type1_id != 0) {
			Predicate type1Pre = cb.equal(type1Root.get(Type1_.TYPE1_ID), type1_id);
			predicate_list.add(type1Pre);
		}
		if (type2_id != 0) {
			Predicate type2Pre = cb.equal(type2Root.get(Type2_.TYPE2_ID), type2_id);
			predicate_list.add(type2Pre);
		}

		StringBuffer searchTextBuffer = new StringBuffer().append("%").append(worksDto.getSearchText()).append("%");
		Predicate worksSubjectPre = cb.like(worksRoot.get(Works_.SUBJECT), searchTextBuffer.toString());
		predicate_list.add(worksSubjectPre);
		
		Predicate notDelYn = cb.equal(worksRoot.get(Works_.DEL_YN), 0);
		predicate_list.add(notDelYn);
		
		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		TypedQuery<Works> typeQuery = em.createQuery(cq.select(worksRoot).where(predicate_array));
		
		Pageable pageable = PageRequest.of(worksDto.getPageNum() - 1, PAGE.PAGE_SIZE);
		
		typeQuery.setFirstResult((int)pageable.getOffset());
		typeQuery.setMaxResults(PAGE.PAGE_SIZE);

		Long totalCount = this.selectWorksDynamicTotalCountForDialog(worksDto, type2, type1, em);
		List<Works> works_list = typeQuery.getResultList();

		List<WorksDto> worksDtoList = new ArrayList<WorksDto>();
		for (Works work : works_list) {
			WorksDto dto = new WorksDto();

			BeanUtils.copyProperties(work, dto);

			worksDtoList.add(dto);
		}

		ResultMap result = new ResultMap();
		result.setData(worksDtoList);
		result.setTotalSize(totalCount);

		em.close();

		return result;
	}

	private Long selectWorksDynamicTotalCountForDialog(WorksDto worksDto, Type2Dto type2, Type1Dto type1, EntityManager em) {
		// TODO Auto-generated method stub

		// EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Works> worksRoot = cq.from(Works.class);

		Join<Works, Type2> type2Root = worksRoot.join(Works_.TYPE2, JoinType.INNER);
		Join<Type2, Type1> type1Root = type2Root.join(Type2_.TYPE1, JoinType.INNER);

		Long type1_id = type1.getType1_id();
		Long type2_id = type2.getType2_id();

		List<Predicate> predicate_list = new ArrayList<Predicate>();

		if (type1_id != 0) {
			Predicate type1Pre = cb.equal(type1Root.get(Type1_.TYPE1_ID), type1_id);
			predicate_list.add(type1Pre);
		}
		if (type2_id != 0) {
			Predicate type2Pre = cb.equal(type2Root.get(Type2_.TYPE2_ID), type2_id);
			predicate_list.add(type2Pre);
		}

		StringBuffer searchTextBuffer = new StringBuffer().append("%").append(worksDto.getSearchText()).append("%");
		Predicate worksSubjectPre = cb.like(worksRoot.get(Works_.SUBJECT), searchTextBuffer.toString());
		predicate_list.add(worksSubjectPre);
		
		Predicate notDelYn = cb.equal(worksRoot.get(Works_.DEL_YN), 0);
		predicate_list.add(notDelYn);

		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		cq.select(cb.count(worksRoot)).where(predicate_array);
		Long count;
		try {
			count = em.createQuery(cq).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			count =0L;
		}

		return count;
	}

	public List<WorksDto> searchWorksDynamic(WorksDto worksDto, Type1Dto type1, Type2Dto type2,
			OrderForSearch orderForSearch) {
		// TODO Auto-generated method stub

		EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Works> cq = cb.createQuery(Works.class);
		Root<Works> worksRoot = cq.from(Works.class);

		Join<Works, Type2> type2Root = worksRoot.join(Works_.TYPE2, JoinType.INNER);
		Join<Type2, Type1> type1Root = type2Root.join(Type2_.TYPE1, JoinType.INNER);
		Join<Works, FileSave> fileSaveRoot = worksRoot.join(Works_.FILE_SAVE, JoinType.LEFT);
		Join<Works, Create_art> createArtRoot = worksRoot.join(Works_.CREATE, JoinType.LEFT);
//		Join<Create_art,Artist> artistRoot = createArtRoot.join("artist",JoinType.LEFT);
		// dynamic join
		Join<Works, Evaluate> evalRoot = null;
		// entity graph
		EntityGraph<Works> works_filesave_entityGraph = em.createEntityGraph(Works.class);
		works_filesave_entityGraph.addAttributeNodes(Works_.FILE_SAVE);
//		EntityGraph<Works> works_create_entityGraph = em.createEntityGraph(Works.class);
		works_filesave_entityGraph.addSubgraph(Works_.CREATE).addAttributeNodes(Create_art_.ARTIST);

		Long type1_id = type1.getType1_id();
		Long type2_id = type2.getType2_id();

		List<Predicate> predicate_list = new ArrayList<Predicate>();
		List<Expression> groupList = new ArrayList<Expression>();
		List<Order> orderList = new ArrayList<Order>();

		if (type1_id != 0) {
			Predicate type1Pre = cb.equal(type1Root.get(Type1_.TYPE1_ID), type1_id);
			predicate_list.add(type1Pre);
		}
		if (type2_id != 0) {
			Predicate type2Pre = cb.equal(type2Root.get(Type2_.TYPE2_ID), type2_id);
			predicate_list.add(type2Pre);
		}

		groupList.add(worksRoot.get(Works_.WORK_ID));
		groupList.add(fileSaveRoot.get(FileSave_.FILE_ID));
		groupList.add(createArtRoot.get(Create_art_.CREATE_ID));

		if (orderForSearch.getOrder() == 0) {

			evalRoot = worksRoot.join(Works_.EVALUATE, JoinType.LEFT);

			if (orderForSearch.getOrder2() == 0) {
				Order order = cb.desc(cb.count(evalRoot.get(Evaluate_.EVAL_ID)));
				orderList.add(order);
			} else if (orderForSearch.getOrder2() == 1) {
				Order order = cb.asc(cb.count(evalRoot.get(Evaluate_.EVAL_ID)));
				orderList.add(order);
			}

		} else if (orderForSearch.getOrder() == 1) {

			if (orderForSearch.getOrder2() == 0) {
				Order order = cb.desc(worksRoot.get(Works_.CREATE_DATE));
				orderList.add(order);
			} else if (orderForSearch.getOrder2() == 1) {
				Order order = cb.asc(worksRoot.get(Works_.CREATE_DATE));
				orderList.add(order);
			}

		}

		StringBuffer searchTextBuffer = new StringBuffer().append("%").append(worksDto.getSearchText()).append("%");
		Predicate worksSubjectPre = cb.like(worksRoot.get(Works_.SUBJECT), searchTextBuffer.toString());
		predicate_list.add(worksSubjectPre);
		
		Predicate notDelYn = cb.equal(worksRoot.get(Works_.DEL_YN), 0);
		predicate_list.add(notDelYn);

		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		Order[] order_array = new Order[orderList.size()];
		order_array = orderList.toArray(order_array);

		Expression[] groupListExpression = new Expression[groupList.size()];
		groupListExpression = groupList.toArray(groupListExpression);

		TypedQuery<Works> typeQuery = em.createQuery(
				cq.select(worksRoot).where(predicate_array).groupBy(groupListExpression).orderBy(order_array));
		
		Pageable pageable = PageRequest.of(worksDto.getPageNum() - 1, PAGE.PAGE_SIZE_NINE);
		
		typeQuery.setFirstResult((int)pageable.getOffset());
		typeQuery.setMaxResults(PAGE.PAGE_SIZE_NINE);

//		typeQuery.setHint("javax.persistence.loadgraph", works_create_entityGraph);
		typeQuery.setHint("javax.persistence.loadgraph", works_filesave_entityGraph);
		Long totalCount = searchWorksDynamicTotalCount(em, worksDto, type1, type2);
		List<Works> works_list = typeQuery.getResultList();
		em.close();

		List<WorksDto> dto_list = new ArrayList<WorksDto>();

		for (Works work : works_list) {
			WorksDto one = new WorksDto();
			BeanUtils.copyProperties(work, one);
			// get the fileList//////////
			List<FileSaveDto> file_list_dto = new ArrayList<FileSaveDto>();

			Set<FileSave> file_set = work.getFileSave();
			List<FileSave> file_list = new ArrayList<FileSave>();
			file_list.addAll(file_set);

			for (FileSave fileSave : file_list) {

				FileSaveDto fileDto = new FileSaveDto();
				BeanUtils.copyProperties(fileSave, fileDto);

				file_list_dto.add(fileDto);
			}
			one.setFileSaveDto(file_list_dto);
			//////////// end/////////////////
			// get the creator/////////////
			///////// need represent creator////////
			Set<Create_art> createArt_set = work.getCreate();
			List<Create_art> createArt_list = new ArrayList<Create_art>();
			createArt_list.addAll(createArt_set);
			
			Collections.sort(createArt_list);
			
			List<ArtistDto> artistDto_list = new ArrayList<>();
			for (Create_art create : createArt_list) {
				Artist artist = create.getArtist();
				ArtistDto artistDto = new ArtistDto();

				BeanUtils.copyProperties(artist, artistDto);

				artistDto_list.add(artistDto);
			}
			/////////// end///////////////////

			one.setArtistDtoList(artistDto_list);
			one.setTotalSize(totalCount);
			dto_list.add(one);
		}

		return dto_list;
	}

	public Long searchWorksDynamicTotalCount(EntityManager em, WorksDto worksDto, Type1Dto type1, Type2Dto type2) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Works> worksRoot = cq.from(Works.class);

		Join<Works, Type2> type2Root = worksRoot.join(Works_.TYPE2, JoinType.INNER);
		Join<Type2, Type1> type1Root = type2Root.join(Type2_.TYPE1, JoinType.INNER);

		Long type1_id = type1.getType1_id();
		Long type2_id = type2.getType2_id();

		List<Predicate> predicate_list = new ArrayList<Predicate>();

		if (type1_id != 0) {
			Predicate type1Pre = cb.equal(type1Root.get(Type1_.TYPE1_ID), type1_id);
			predicate_list.add(type1Pre);
		}
		if (type2_id != 0) {
			Predicate type2Pre = cb.equal(type2Root.get(Type2_.TYPE2_ID), type2_id);
			predicate_list.add(type2Pre);
		}

		StringBuffer searchTextBuffer = new StringBuffer().append("%").append(worksDto.getSearchText()).append("%");
		Predicate worksSubjectPre = cb.like(worksRoot.get(Works_.SUBJECT), searchTextBuffer.toString());
		predicate_list.add(worksSubjectPre);
		
		Predicate notDelYn = cb.equal(worksRoot.get(Works_.DEL_YN), 0);
		predicate_list.add(notDelYn);

		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		Long totalCount;
		try {
			totalCount = em.createQuery(cq.select(cb.count(worksRoot)).where(predicate_array)).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			totalCount =0L;
		}

		return totalCount;
	}


}
