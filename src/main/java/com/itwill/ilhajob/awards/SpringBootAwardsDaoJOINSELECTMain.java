package com.itwill.ilhajob.awards;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.Awards.mapper")
public class SpringBootAwardsDaoJOINSELECTMain {

	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootAwardsDaoJOINSELECTMain.class, args);
		AwardsDao awardsDao=(AwardsDao)appicationContext.getBean(AwardsDao.class);
		System.out.println("---------AwardsDaoTEST------------------");
		System.out.println(awardsDao.findAwardsList());
		System.out.println(awardsDao.findAwards(2));
		System.out.println(awardsDao.findAwardsOfUser(2));
		

	}

}