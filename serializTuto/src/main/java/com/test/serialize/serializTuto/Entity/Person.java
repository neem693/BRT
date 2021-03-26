package com.test.serialize.serializTuto.Entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4980561058826677579L;
	static String country = "ITALY";
	private int age;
	private String name;
	transient int height;

}
