package com.naver.b1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomSchedule {
	
	//@Scheduled(fixedRate = 1000)
	@Scheduled(fixedRateString = "1000")
	public void fixRateSchedule() throws Exception {
		//System.out.println("FixRate" +Thread.currentThread().getName());
		//Thread.sleep(2000);
	}
	
	//@Scheduled(fixedDelay = 1000)
	@Scheduled(fixedDelayString = "1000")
	public void fixedDelaySchedule() throws Exception{
		//System.out.println("FixDelay"+Thread.currentThread().getName());
		//Thread.sleep(2000);
	}

	@Scheduled(cron = "0 50 * * * *")
	public void cronSchedule() throws Exception{
		//System.out.println("쉬는 시간 지킵시다.."+Thread.currentThread().getName());
		
	}
	
}
