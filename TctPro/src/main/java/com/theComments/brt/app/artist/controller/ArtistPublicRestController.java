package com.theComments.brt.app.artist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.app.artist.service.ArtistService;
import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/artistPublic")
public class ArtistPublicRestController {
	
	@Autowired
	ArtistService artistService;
	
	@RequestMapping(value ="/artistSearch",method=RequestMethod.GET)
	public Map<String,Object> artsitSearch(Long type1, Long type2, String searchText, Integer order, Integer order2,
			Integer pageNum){
		
		ResultMap result = artistService.artistSearch(type1, type2, searchText, order, order2, pageNum);
		
		return result.getResultMap();
	}

}
