package com.theComments.brt.jpa.theComment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.theComments.brt.constFile.PageConst.PAGE;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.jpa.theComment.model.Type1;
import com.theComments.brt.jpa.theComment.model.Type2;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.util.ResultMap;

@Component
public class DynamicQueryDao {

	@Autowired
	@Qualifier("emFac1")
	EntityManagerFactory entityManagerFactory;

	public ResultMap SelectWorksDynamic(WorksDto worksDto, Type2Dto type2, Type1Dto type1) {
		EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Works> cq = cb.createQuery(Works.class);
		Root<Works> worksRoot = cq.from(Works.class);

		Join<Works, Type2> type2Root = worksRoot.join("type2", JoinType.INNER);
		Join<Type2, Type1> type1Root = type2Root.join("type1", JoinType.INNER);

		Long type1_id = type1.getType1_id();
		Long type2_id = type2.getType2_id();

		List<Predicate> predicate_list = new ArrayList<Predicate>();
		
		if (type1_id != 0) {
			Predicate type1Pre = cb.equal(type1Root.get("type1_id"), type1_id);
			predicate_list.add(type1Pre);
		}
		if (type2_id != 0) {
			Predicate type2Pre = cb.equal(type2Root.get("type2_id"), type2_id);
			predicate_list.add(type2Pre);
		}

		StringBuffer searchTextBuffer = new StringBuffer().append("%").append(worksDto.getSearchText()).append("%");
		Predicate worksSubjectPre = cb.like(worksRoot.get("subject"), searchTextBuffer.toString());
		predicate_list.add(worksSubjectPre);

		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		TypedQuery<Works> typeQuery = em.createQuery(cq.select(worksRoot).where(predicate_array));
		typeQuery.setFirstResult(worksDto.getPageNum() - 1);
		typeQuery.setMaxResults(PAGE.PAGE_SIZE);

		Long totalCount = this.selectWorksDynamicTotalCount(worksDto, type2, type1,em);
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

	private Long selectWorksDynamicTotalCount(WorksDto worksDto, Type2Dto type2, Type1Dto type1,EntityManager em) {
		// TODO Auto-generated method stub

		//EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Works> worksRoot = cq.from(Works.class);

		Join<Works, Type2> type2Root = worksRoot.join("type2", JoinType.INNER);
		Join<Type2, Type1> type1Root = type2Root.join("type1", JoinType.INNER);

		Long type1_id = type1.getType1_id();
		Long type2_id = type2.getType2_id();

		List<Predicate> predicate_list = new ArrayList<Predicate>();
		
		if (type1_id != 0) {
			Predicate type1Pre = cb.equal(type1Root.get("type1_id"), type1_id);
			predicate_list.add(type1Pre);
		}
		if (type2_id != 0) {
			Predicate type2Pre = cb.equal(type2Root.get("type2_id"), type2_id);
			predicate_list.add(type2Pre);
		}

		StringBuffer searchTextBuffer = new StringBuffer().append("%").append(worksDto.getSearchText()).append("%");
		Predicate worksSubjectPre = cb.like(worksRoot.get("subject"), searchTextBuffer.toString());
		predicate_list.add(worksSubjectPre);

		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		cq.select(cb.count(worksRoot)).where(predicate_array);
		Long count = em.createQuery(cq).getSingleResult();

		return count;
	}

}
