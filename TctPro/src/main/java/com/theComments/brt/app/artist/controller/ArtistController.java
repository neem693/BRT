package com.theComments.brt.app.artist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theComments.brt.app.artist.service.ArtistService;
import com.theComments.brt.jpa.dto.ArtistDto;
import com.theComments.brt.util.ResultMap;

@RestController
@RequestMapping("/v1/artist")
public class ArtistController {
	
	@Autowired
	ArtistService artistService;
	
	@RequestMapping(value = "/artistSave", method = RequestMethod.POST)
	public Map<String,Object> artistSave(@RequestBody Map<String,Object> data) {
		
		ResultMap result = artistService.artistSave(data);
		
		return result.getResultMap();
	}
	
	@RequestMapping(value = "/artistSelectOne",method =RequestMethod.GET)
	public Map<String,Object> artistSelectOne(@RequestParam Map<String,Object> param) {
		
		ResultMap result = artistService.artistSelectOne(param);
		
		return  result.getResultMap();
	}
	
	/**
	 * common select artist List
	 * @param artistDto
	 * @return
	 */
	@RequestMapping(value = "/selectArtistList",method=RequestMethod.POST)
	public Map<String,Object> selectArtistList(@RequestBody ArtistDto artistDto){
		
		ResultMap result =  artistService.selectArtistList(artistDto);
		
		return result.getResultMap();
	}
	
	/**
	 * return artist Search data
	 * parma -> type1?,type2?,pageSearchText,pageNum
	 * @param artistDto
	 * @return
	 */
	@RequestMapping(value = "/artistSearch",method=RequestMethod.GET)
	public Map<String,Object> artistSearch(@RequestParam Map<String,Object> param){
		
		ResultMap result = artistService.artistSearch(param);
		
		return result.getResultMap();
	}

}
