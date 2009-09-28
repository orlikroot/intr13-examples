package ru.intr13.example.springTransactionalTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" }, true);
		DataDao dataDao = (DataDao) context.getBean("dataDao");
		Data data1 = new Data("one");
		dataDao.save(data1);
		Data data2 = new Data("two");
		dataDao.save(data2);
		Data data3 = new Data("three");
		dataDao.save(data3);
		System.out.println(dataDao.find("%o%").size());
	}

}
