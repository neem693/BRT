package com.theComments.brt.jpa.theComment.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theComments.brt.constFile.PageConst;
import com.theComments.brt.constFile.PageConst.PAGE;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.jpa.dto.Evaluation_itemDto;
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
import com.theComments.brt.jpa.theComment.model.Evaluation_item;
import com.theComments.brt.jpa.theComment.model.Evaluation_item_;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.FileSave_;
import com.theComments.brt.jpa.theComment.model.QArtist;
import com.theComments.brt.jpa.theComment.model.QCreate_art;
import com.theComments.brt.jpa.theComment.model.QEvaluate;
import com.theComments.brt.jpa.theComment.model.QEvaluation_item;
import com.theComments.brt.jpa.theComment.model.QType1;
import com.theComments.brt.jpa.theComment.model.QType2;
import com.theComments.brt.jpa.theComment.model.QWorks;
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
public class DynamicQueryDao {

	@Autowired
	@Qualifier("emFac1")
	EntityManagerFactory entityManagerFactory;

	public ResultMap SelectWorksDynamic(WorksDto worksDto, Type2Dto type2, Type1Dto type1) {
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

		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		TypedQuery<Works> typeQuery = em.createQuery(cq.select(worksRoot).where(predicate_array));
		typeQuery.setFirstResult(worksDto.getPageNum() - 1);
		typeQuery.setMaxResults(PAGE.PAGE_SIZE);

		Long totalCount = this.selectWorksDynamicTotalCount(worksDto, type2, type1, em);
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

	private Long selectWorksDynamicTotalCount(WorksDto worksDto, Type2Dto type2, Type1Dto type1, EntityManager em) {
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
		 * Evaluation_item ei INNER JOIN Evaluate e ON ei.eval_item_id = e.eval_item_id
		 * INNER JOIN Works w ON w.work_id = e.works_id WHERE w.work_id = 2 ) as result
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
				+ "            Evaluation_item ei    \r\n" + "        INNER JOIN\r\n" + "            Evaluate e   \r\n"
				+ "                ON ei.eval_item_id = e.eval_item_id    \r\n" + "        INNER JOIN\r\n"
				+ "            Works w   \r\n" + "                ON w.work_id = e.works_id   \r\n"
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
				+ "ei.subjectMatter          \r\n" + "FROM\r\n" + "Evaluation_item ei              \r\n"
				+ "INNER JOIN\r\n" + "Evaluate e                     \r\n"
				+ "ON ei.eval_item_id = e.eval_item_id              \r\n" + "INNER JOIN\r\n"
				+ "Works w                     \r\n" + "ON w.work_id = e.works_id             \r\n" + "WHERE\r\n"
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

		Predicate[] predicate_array = new Predicate[predicate_list.size()];
		predicate_array = predicate_list.toArray(predicate_array);

		Order[] order_array = new Order[orderList.size()];
		order_array = orderList.toArray(order_array);

		Expression[] groupListExpression = new Expression[groupList.size()];
		groupListExpression = groupList.toArray(groupListExpression);

		TypedQuery<Works> typeQuery = em.createQuery(
				cq.select(worksRoot).where(predicate_array).groupBy(groupListExpression).orderBy(order_array));
		typeQuery.setFirstResult(worksDto.getPageNum() - 1);
		typeQuery.setMaxResults(PAGE.PAGE_SIZE);

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

	public Map<String,Object> searchArtistDynamic(ArtistDto artistDto, Type1Dto type1Dto, Type2Dto type2Dto,
			OrderForSearch orderForSearch) {
		// TODO Auto-generated method stub

		EntityManager em = entityManagerFactory.createEntityManager();
		String select_str =
				"SELECT \r\n" + 
				"a.artist_id,\r\n" + 
				"a.art_name, \r\n" + 
				"(sum(CASE  \r\n" + 
				"             WHEN t1.TYPE1_ID = 1 THEN 1 \r\n" + 
				"              ELSE 0 \r\n" + 
				"END)) see,\r\n" + 
				"(sum(CASE  \r\n" + 
				"             WHEN t1.TYPE1_ID = 2 THEN 1 \r\n" + 
				"              ELSE 0 \r\n" + 
				"END)) listen,\r\n" + 
				"(sum(CASE  \r\n" + 
				"             WHEN t1.TYPE1_ID = 3 THEN 1 \r\n" + 
				"              ELSE 0 \r\n" + 
				"END)) doo,\r\n" + 
				"count(t1.type1_id) count,\r\n" + 
				"max(w.create_date) worksMax\r\n";
		String query_str = 
				"FROM ARTIST a \r\n" + 
				"inner join CREATE_ART ca\r\n" + 
				"on a.artist_id = ca.artist_id\r\n" + 
				"inner join works w\r\n" + 
				"on ca.work_id = w.work_id\r\n" + 
				"inner join TYPE2 t2\r\n" + 
				"on t2.type2_id = w.type2_id\r\n" + 
				"inner join TYPE1 t1\r\n" + 
				"on t2.type1_id = t1.type1_id\r\n";
		
		if(type1Dto.getType1_id() != 0 || artistDto.getSearchText() != "" ) {
			
			query_str += "where 1=1 ";
			
		}
		
		if(type1Dto.getType1_id() != 0) {
			
			query_str +="and t1.type1_id = " + type1Dto.getType1_id();
			if(type2Dto.getType2_id() != 0) {
				query_str +="and t2.type2_id = "+ type2Dto.getType2_id();
			}
		}
		
		if(artistDto.getSearchText() != "") {
			query_str +="and a.art_name like "+ "'%" + artistDto.getSearchText() + "%'";
		}
		
		query_str+="group by a.artist_id";
		
		String order = " order by";
		if(orderForSearch.getOrder() ==0) {
			order += " worksMax";
			
			if(orderForSearch.getOrder2() ==0) {
				order += " desc,count desc";
			}else if(orderForSearch.getOrder2() == 1) {
				order += " asc,count desc";
			}
			
		}else if(orderForSearch.getOrder() == 1) {
			
			order += " count";
			
			if(orderForSearch.getOrder2() ==0) {
				order += " desc,worksMax desc";
			}else if(orderForSearch.getOrder2() == 1) {
				order += " asc,worksMax desc";
			}
		}
		
		int pageNum =artistDto.getPageNum()-1;
		int pageSize = PageConst.PAGE.PAGE_SIZE;
		String limit = " limit "+pageNum + "," + pageSize; 
		
		System.out.println(select_str + query_str + order+ limit);
		
		Query query = em.createNativeQuery(select_str + query_str + order + limit,"artistSearch");
		List<ArtistDto> data = query.getResultList();
		Query queryCount = em.createNativeQuery("SELECT COUNT(*)" + query_str);
		BigInteger totalCount;
		try {
			totalCount = (BigInteger)queryCount.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			totalCount =new BigInteger("0");
		}
		em.close();
		
		Map<String,Object> returnData = new HashMap<String, Object>();
		returnData.put("data", data);
		returnData.put("totalSize", totalCount.longValue());

		return returnData;
	}

	public List selectEvalItemSearchBasic(
			Evaluation_itemDto itemDto, 
			Type1Dto type1Dto, 
			Type2Dto type2Dto,
			OrderForSearch orderForSearch
			) {
		// TODO Auto-generated method stub
		
		QEvaluation_item qEval = QEvaluation_item.evaluation_item;
		
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
//		Long totalCount = selectEvalItemSearchBasicTotalCount(em, worksDto, type1, type2);
		List<Evaluation_item> works_list = typeQuery.getResultList();
		
		em.close();
		
		return null;
		
	}

}
