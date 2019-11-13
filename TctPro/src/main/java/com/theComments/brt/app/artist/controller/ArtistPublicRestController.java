package com.theComments.brt.app.artist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.app.artist.service.ArtistService;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/artistPublic")
public class ArtistPublicRestController {
	
	@Autowired
	ArtistService artistService;
	
	@RequestMapping(value ="/artistSearch",method=RequestMethod.GET)
	public Map<String,Object> artsitSearch(@RequestParam Map<String,Object> param){
		
		ResultMap result = artistService.artistSearch(param);
		
		return result.getResultMap();
	}

}
