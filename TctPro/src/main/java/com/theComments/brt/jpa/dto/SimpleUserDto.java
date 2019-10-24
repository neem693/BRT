package com.theComments.brt.jpa.dto;
/**
 * 
 * @author UIO
 * 해당하는 클래스는 ResoueServer에서 userid와 username만을 가지고 올 수 있도록 
 * 만들어진 pojo 클래스라고 하면 된다.
 */

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleUserDto {
	String user_name;
	Long userId;
	List<String> authorities;
}
