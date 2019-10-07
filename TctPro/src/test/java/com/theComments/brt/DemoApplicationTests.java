package com.theComments.brt;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.theComments.brt.jpa.theComment.dao.Artist_dao;
import com.theComments.brt.jpa.theComment.model.Artist;
import com.theComments.brt.jpa.theComment.model.Create_art;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	Artist_dao dao;
	
	@Test
	public void doit() {
		
		List<Artist> list = dao.queryArtistExam();
		List<Create_art> list2 = list.get(0).getCreate();
		System.out.println(list2);
		System.out.println(list2.get(0).getWorks());
		System.out.println("wefwfw");
		
	}

}
