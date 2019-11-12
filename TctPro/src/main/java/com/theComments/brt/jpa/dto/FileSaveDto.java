package com.theComments.brt.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileSaveDto {
	
	Long file_idNeedSecurity;

	String file_name;
	String file_path;
	String save_file_name;
	String save_file_pathNeedSecurity;
	String file_typeNeedSecurity;

	WorksDto works;

}
