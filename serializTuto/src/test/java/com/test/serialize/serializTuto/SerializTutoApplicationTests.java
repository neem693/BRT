package com.test.serialize.serializTuto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.serialize.serializTuto.Entity.Person;

@SpringBootTest
class SerializTutoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void whenSerializingAndSeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
		
		Person person = new Person();
		person.setAge(20);
		person.setName("Joe");
		
		FileOutputStream fileOutputstream = new FileOutputStream("yourfile.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputstream);
		objectOutputStream.writeObject(person);
		objectOutputStream.flush();
		objectOutputStream.close();
		
		FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Person p2 = (Person)objectInputStream.readObject();
		objectInputStream.close();
		
		assertTrue(p2.getAge() == person.getAge());
//		assertTrue(p2.getAge() == 36);
		assertTrue(p2.getName().equals(person.getName()));
		
		
		
	}

}
