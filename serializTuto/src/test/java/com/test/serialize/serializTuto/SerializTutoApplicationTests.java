package com.test.serialize.serializTuto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.serialize.serializTuto.Entity.Address;
import com.test.serialize.serializTuto.Entity.Employee;
import com.test.serialize.serializTuto.Entity.Person;
import com.test.serialize.serializTuto.Entity.Person2;

@SpringBootTest
class SerializTutoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void whenSerializingAndSeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
		
		Person2 person = new Person2();
		person.setAge(20);
		person.setName("Joe");
		
		Address country = new Address();
		country.setHouseNumber(149);
		
		person.setCountry(country);
		
		FileOutputStream fileOutputstream = new FileOutputStream("yourfile.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputstream);
		objectOutputStream.writeObject(person);
		objectOutputStream.flush();
		objectOutputStream.close();
		
		FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Person2 p2 = (Person2)objectInputStream.readObject();
		objectInputStream.close();
		
		assertTrue(p2.getAge() == person.getAge());
		assertTrue(p2.getName().equals(person.getName()));
		assertNotNull(person.getCountry());
		assertNull(p2.getCountry());
		
		
	}
	
	@Test
	public void whenCustomSerializingAndDeserializing_ThenObjectsIsTheSame() throws IOException, ClassNotFoundException {
		
		Person p = new Person();
		p.setAge(20);
		p.setName("Joe");
		
		Address a = new Address();
		a.setHouseNumber(1);
		
		Employee e = new Employee();
		e.setPerson(p);
		e.setAddress(a);
		
		FileOutputStream fileOutputStream = new FileOutputStream("yourfile2.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(e);
		objectOutputStream.flush();
		objectOutputStream.close();
		
		FileInputStream fileInputStream = new FileInputStream("yourfile2.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Employee e2 = (Employee) objectInputStream.readObject();
		objectInputStream.close();
		
		assertTrue(e2.getPerson().getAge() == e.getPerson().getAge());
		assertTrue(e2.getAddress().getHouseNumber() == e.getAddress().getHouseNumber());
		
	}

}
