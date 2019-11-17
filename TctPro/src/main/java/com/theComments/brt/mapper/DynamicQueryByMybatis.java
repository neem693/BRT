package com.theComments.brt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DynamicQueryByMybatis {
	
	public List searchArtist();
	

}
