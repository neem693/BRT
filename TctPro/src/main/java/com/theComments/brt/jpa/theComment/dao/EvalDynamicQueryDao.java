package com.theComments.brt.jpa.theComment.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.theComments.brt.constFile.PageConst.PAGE;
import com.theComments.brt.jpa.dto.Evaluation_itemDto;
import com.theComments.brt.jpa.dto.OrderForSearch;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.theComment.model.Evaluate;
import com.theComments.brt.jpa.theComment.model.Evaluate_;
import com.theComments.brt.jpa.theComment.model.Evaluation_item;
import com.theComments.brt.jpa.theComment.model.Evaluation_item_;
import com.theComments.brt.jpa.theComment.model.Works;
import com.theComments.brt.jpa.theComment.model.Works_;
import com.theComments.brt.util.ResultMap;

/***
 * 
 * @author UIO dynamic query or custom query for native query .. etc
 */
@Component
public class EvalDynamicQueryDao {

	@Autowired
	@Qualifier("emFac1")
	EntityManagerFactory entityManagerFactory;

	/**
	 * query matter when eval the item
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	public ResultMap selectMatter(Long work_id, int page, int size) {
		// TODO Auto-generated method stub
		EntityManager em = entityManagerFactory.createEntityManager();
		/*
		 * SELECT result.subjectMatter, SUM(CASE WHEN result.ev_value>=6 THEN 1 ELSE 0
		 * END) as yellow, SUM(CASE WHEN result.ev_value>=4 and result.ev_value <=5 THEN
		 * 1 ELSE 0 END) as blue, SUM(CASE WHEN result.ev_value>=2 and result.ev_value
		 * <=3 THEN 1 ELSE 0 END) as gray, SUM(CASE WHEN result.ev_value=1 THEN 1 ELSE 0
		 * END) as black FROM ( SELECT ei.subjectMatter, ei.ev_value FROM
		 * evaluation_item ei INNER JOIN evaluate e ON ei.eval_item_id = e.eval_item_id
		 * INNER JOIN WORKS w ON w.work_id = e.works_id WHERE w.work_id = 2 ) as result
		 * GROUP BY result.subjectMatter
		 */
		Query query = em.createNativeQuery("SELECT\r\n" + "        result.subjectMatter,\r\n" + "        SUM(CASE \r\n"
				+ "            WHEN result.ev_value>=6 THEN 1 \r\n" + "            ELSE 0 \r\n"
				+ "        END) as yellow,\r\n" + "        SUM(CASE \r\n" + "            WHEN result.ev_value>=4 \r\n"
				+ "            and result.ev_value <=5 THEN 1 \r\n" + "            ELSE 0 \r\n"
				+ "        END) as blue,\r\n" + "        SUM(CASE \r\n" + "            WHEN result.ev_value>=2 \r\n"
				+ "            and result.ev_value <=3 THEN 1 \r\n" + "            ELSE 0 \r\n"
				+ "        END) as gray,\r\n" + "        SUM(CASE \r\n"
				+ "            WHEN result.ev_value=1 THEN 1 \r\n" + "            ELSE 0 \r\n"
				+ "        END) as black   \r\n" + "    FROM\r\n" + "        (   SELECT\r\n"
				+ "            ei.subjectMatter,\r\n" + "            ei.ev_value   \r\n" + "        FROM\r\n"
				+ "            evaluation_item ei    \r\n" + "        INNER JOIN\r\n" + "            evaluate e   \r\n"
				+ "                ON ei.eval_item_id = e.eval_item_id    \r\n" + "        INNER JOIN\r\n"
				+ "            WORKS w   \r\n" + "                ON w.work_id = e.works_id   \r\n"
				+ "        WHERE\r\n" + "            w.work_id = :work_id   ) as result   \r\n" + "    GROUP BY\r\n"
				+ "        result.subjectMatter", "selectSubjectMatterGroup");

		query.setParameter("work_id", work_id);
		query.setFirstResult(page);
		query.setMaxResults(size);

		List<Evaluation_itemDto> list = query.getResultList();
		Long count = this.selectMatter(em, work_id, page, size);
		em.close();

		ResultMap result = new ResultMap();
		result.setData(list);
		result.setTotalSize(count);

		return result;
	}

	private Long selectMatter(EntityManager em, Long work_id, int page, int size) {
		// TODO Auto-generated method stub

		Query query = em.createNativeQuery("SELECT\r\n" + "count(*)      \r\n" + "FROM\r\n" + "(SELECT\r\n"
				+ "ei.subjectMatter          \r\n" + "FROM\r\n" + "evaluation_item ei              \r\n"
				+ "INNER JOIN\r\n" + "evaluate e                     \r\n"
				+ "ON ei.eval_item_id = e.eval_item_id              \r\n" + "INNER JOIN\r\n"
				+ "WORKS w                     \r\n" + "ON w.work_id = e.works_id             \r\n" + "WHERE\r\n"
				+ "w.work_id =:work_id\r\n" + "group by ei.subjectMatter\r\n" + " ) as result");

		query.setParameter("work_id", work_id);
		
		BigInteger count;
		try {
			count = (BigInteger) query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			count = new BigInteger("0");
		}

		return count.longValue();
	}
	
	public Map<String,Object> selectEvalItemSearchBasic(
			Evaluation_itemDto itemDto, 
			Type1Dto type1Dto, 
			Type2Dto type2Dto,
			OrderForSearch orderForSearch
			) {
		// TODO Auto-generated method stub
		
		EntityManager em = entityManagerFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Evaluation_item> cq = cb.createQuery(Evaluation_item.class);
		
		Root<Evaluation_item> rEvalItemRoot = cq.from(Evaluation_item.class);
		
		Join<Evaluation_item, Evaluate> rEvalJoinRoot = rEvalItemRoot.join(Evaluation_item_.EVALUATE, JoinType.INNER);
		Join<Evaluate, Works> rWorksJoinRoot = rEvalJoinRoot.join(Evaluate_.WORKS, JoinType.INNER);
		
		List<Predicate> predicate_list = new ArrayList<Predicate>();
		List<Expression> groupList = new ArrayList<Expression>();
		List<Order> orderList = new ArrayList<Order>();
		
		if(itemDto.getSearchText().isEmpty() == false) {
			
			String searchWords = "%" + itemDto.getSearchText() + "%";
			
			//comment
			if(orderForSearch.getOrder3() == 0) {
				Predicate con = cb.and(cb.like(rEvalItemRoot.get(Evaluation_item_.EV_TEXT1), searchWords),
						cb.or(cb.like(rEvalItemRoot.get(Evaluation_item_.EV_TEXT2), searchWords)));
				predicate_list.add(con);
				
//				booleanBuilder.and(qEval_item.ev_text1.like(searchWords)
//								.or(qEval_item.ev_text2.like(searchWords)));
//					
			}else if(orderForSearch.getOrder3() == 1) {
				
				Predicate con = cb.and(cb.like(rEvalItemRoot.get(Evaluation_item_.SUBJECT_MATTER), searchWords));
				predicate_list.add(con);
//				booleanBuilder.and(qEval_item.subjectMatter.like(searchWords));
				
			}
		}
		
		if(orderForSearch.getOrder2() == 0) {
			if(orderForSearch.getOrder() == 0) {
				
				Order order = cb.desc(rEvalJoinRoot.get(Evaluate_.EVAL_DATE));
				orderList.add(order);
//				orderList.add(qEval.eval_date.desc());
				
			}else if(orderForSearch.getOrder() == 1) {
				
				Order order = cb.asc(rEvalJoinRoot.get(Evaluate_.EVAL_DATE));
				orderList.add(order);
//				orderList.add(qEval.eval_date.asc());
				
			}
		}else if(orderForSearch.getOrder2() == 1) {
			if(orderForSearch.getOrder() == 0) {
				
				Order order = cb.asc(rWorksJoinRoot.get(Works_.CREATE_DATE));
				orderList.add(order);
//				orderList.add(qWorks.create_date.desc());
				
			}else if(orderForSearch.getOrder() == 1) {
				
				Order order = cb.asc(rWorksJoinRoot.get(Works_.CREATE_DATE));
				orderList.add(order);
//				orderList.add(qWorks.create_date.asc());
				
			}
		}
		
		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		Order[] order_array = new Order[orderList.size()];
		order_array = orderList.toArray(order_array);

		Expression[] groupListExpression = new Expression[groupList.size()];
		groupListExpression = groupList.toArray(groupListExpression);
		
		TypedQuery<Evaluation_item> typeQuery = em.createQuery(
				cq.select(rEvalItemRoot)
				.where(predicate_array)
				.groupBy(groupListExpression)
				.orderBy(order_array)
				);
		typeQuery.setFirstResult(itemDto.getPageNum() - 1);
		typeQuery.setMaxResults(PAGE.PAGE_SIZE);
		
		EntityGraph<Evaluation_item> evalItemListMain = (EntityGraph<Evaluation_item>)em.getEntityGraph("evaluation_item.listMain");
		typeQuery.setHint("javax.persistence.loadgraph", evalItemListMain);
		Long totalCount = selectEvalItemSearchBasicTotalCount(em, itemDto, type1Dto, type2Dto,orderForSearch);
		List<Evaluation_item> evalItem_list = typeQuery.getResultList();
		
		for(Evaluation_item item : evalItem_list) {
			
			
			
		}
		
		em.close();
		
		return null;
	}
	

	private Long selectEvalItemSearchBasicTotalCount(
			EntityManager em, 
			Evaluation_itemDto itemDto, 
			Type1Dto type1Dto,
			Type2Dto typeDto,
			OrderForSearch orderForSearch) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		
		Root<Evaluation_item> rEvalItemRoot = cq.from(Evaluation_item.class);
		
		Join<Evaluation_item, Evaluate> rEvalJoinRoot = rEvalItemRoot.join(Evaluation_item_.EVALUATE, JoinType.INNER);
		Join<Evaluate, Works> rWorksJoinRoot = rEvalJoinRoot.join(Evaluate_.WORKS, JoinType.INNER);
		
		List<Predicate> predicate_list = new ArrayList<Predicate>();
		List<Expression> groupList = new ArrayList<Expression>();
		List<Order> orderList = new ArrayList<Order>();
		
		if(itemDto.getSearchText().isEmpty() == false) {
			
			String searchWords = "%" + itemDto.getSearchText() + "%";
			
			//comment
			if(orderForSearch.getOrder3() == 0) {
				Predicate con = cb.and(cb.like(rEvalItemRoot.get(Evaluation_item_.EV_TEXT1), searchWords),
						cb.or(cb.like(rEvalItemRoot.get(Evaluation_item_.EV_TEXT2), searchWords)));
				predicate_list.add(con);
				
//				booleanBuilder.and(qEval_item.ev_text1.like(searchWords)
//								.or(qEval_item.ev_text2.like(searchWords)));
//					
			}else if(orderForSearch.getOrder3() == 1) {
				
				Predicate con = cb.and(cb.like(rEvalItemRoot.get(Evaluation_item_.SUBJECT_MATTER), searchWords));
				predicate_list.add(con);
//				booleanBuilder.and(qEval_item.subjectMatter.like(searchWords));
				
			}
		}
		
		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);
		
		TypedQuery<Long> typeQuery = em.createQuery(
				cq.select(cb.count(rEvalItemRoot))
				.where(predicate_array)
				);
		
		Long totalCount = typeQuery.getSingleResult();
		return totalCount;
	}
	

}
