package com.test.serialize.serializTuto.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5126303317149256680L;
	
	private int age;
	private String name;
	private Address country; // must be serializable too

}
