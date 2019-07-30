package com.framework.Tct.config;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sceduling {
	
	@Scheduled(cron = "0 * 0 * * ?")
	public void cronJobSch() {
		//테스트 할 당시에 00시였음
		//00시 마다 1분 마다
		System.out.println(new Date());
	}
	
//	@Scheduled(fixedRate = 1000)
//	public void cronJobSch2() {
//		//1초마다
//		System.out.println(new Date() + "fixedRate : 1000");
//	}
//	
//	@Scheduled(fixedRate = 1000, initialDelay = 3000)
//	public void cronJobSch3() {
//		//1초의 예약을 3초간 딜레이 시킴
//		System.out.println(new Date() + "fixedRate : 1000 initialDelay:3000");
//	}
	

}
