package com.theComments.brt.app.works.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.theComments.brt.app.works.service.WorksService;
import com.theComments.brt.jpa.dto.Type1Dto;
import com.theComments.brt.jpa.dto.Type2Dto;
import com.theComments.brt.jpa.dto.WorksDto;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/works")
public class WorksController {

	@Autowired
	WorksService worksService;
	
	@Autowired
	HttpServletResponse response;

	@RequestMapping(value = "/workSave",method = RequestMethod.POST)
	public Map<String,Object> worksSave(@RequestParam("fileList") MultipartFile[] f, @RequestParam Map<String, Object> data) throws Exception {

		ResultMap result = worksService.saveWorks(f, data);
		
		int result_code = result.getResult();
		
		if(result_code == 200) {
			
		}
		if(result_code == 201) {
			result.setMessage("201111:need Artist to regist");
		}
		
		return result.getResultMap();

	}
	
	@RequestMapping(value = "/worksSelectOne",method = RequestMethod.GET)
	public Map<String,Object> worksSelectOne(@RequestParam Map<String,Object> param) {

		ResultMap result = worksService.worksSelectOne(param);
		
		int result_code = result.getResult();
		
		if(result_code == 200) {
			
			
		}
		if(result_code == 201) {
			//result.setMessage("201111:need Artist to regist");
		}
		
		return result.getResultMap();

	}

	@RequestMapping(value = "/selectWorks",method=RequestMethod.POST)
	public Map<String,Object> selectWorks(@RequestBody WorksDto worksDto){
		
		ResultMap result = worksService.selectWorksForDialog(worksDto);
		
		return result.getResultMap();
	}
	/**
	 * 
	 * @param worksDto
	 * @param type 저작물에 대해서 총체적으로 검색 할시 type에 대한 정보가 있다면 그것에 대한 정보도 같이 전달 함;
	 * @return
	 */
	@RequestMapping(value = "/selectWorksDetail",method=RequestMethod.POST)
	public Map<String,Object> selectWorksDetail(@RequestBody Map<String,Object> type){
		
		//ResultMap result = worksService.selectWorks(worksDto);
		WorksDto worksDto = new WorksDto();
		
		worksDto.setSearchText(type.get("searchText").toString());
		worksDto.setPageNum(Integer.parseInt(type.get("pageNum").toString()));
		
		Type1Dto type1Dto = new Type1Dto();
		type1Dto.setType1_id(Long.parseLong(type.get("type1Value").toString()));
		
		Type2Dto type2Dto = new Type2Dto();
		type2Dto.setType2_id(Long.parseLong(type.get("type2Value").toString()));
		
		type2Dto.setType1Dto(type1Dto);
		worksDto.setType2(type2Dto);
		
		ResultMap result = worksService.selectWorksDetailForDialog(worksDto);
		
		return result.getResultMap();
	}

}
