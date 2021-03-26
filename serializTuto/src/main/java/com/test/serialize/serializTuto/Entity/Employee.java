package com.test.serialize.serializTuto.Entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1597326212026450014L;
	private transient Address address;
	private Person person;
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		
		oos.defaultWriteObject();
		oos.writeObject(address.getHouseNumber());

	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		
		ois.defaultReadObject();
		Integer houseNumber = (Integer) ois.readObject();
		Address a = new Address();
		a.setHouseNumber(houseNumber);
		this.setAddress(a);
		
	}
	
		
	

}
