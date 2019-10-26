package com.theComments.brt.util;

import java.util.HashMap;
import java.util.Map;

/**
 * RESULT에 대해서 요약한것, Integer result,Integer id, String message, Object data 가 각각 존재
 * id는 insert를 하던가 했을 때 가져오는 저장된 id값
 * Result는 신호를 의미(200성공, 201부터 임의의 의미를 지님)
 * message는 상세 에러나, 특이사항
 * @author UIO
 *
 */
public class ResultMap {
	
	Integer result;
	Long id;
	String message;
	Object data;
	
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Map<String,Object> getResultMap(){
		Map<String,Object> result = new HashMap<String, Object>();
		
		result.put("result",this.getResult());
		result.put("id",this.getId());
		result.put("message",this.getMessage());
		result.put("data",this.getData());
		
		return result;
		
	}
	

	
	
}
