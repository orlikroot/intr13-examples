package ru.intr13.example.jboss.ejb3.test;

import javax.naming.InitialContext;

import junit.framework.Assert;

import org.jboss.embedded.Bootstrap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.intr13.example.jboss.ejb3.api.IMyService;
import ru.intr13.example.jboss.ejb3.impl.MyService;

public class MyServiceTestCase {

	private Bootstrap bootstrap;

	@Before
	public void start() throws Exception {
		bootstrap = Bootstrap.getInstance();
		bootstrap.bootstrap();
	}

	@After
	public void stop() {
		bootstrap.shutdown();
	}

	@Test
	public void testSum() throws Exception {
		bootstrap.deployResourceBase(MyService.class);

		IMyService myService = (IMyService) new InitialContext()
				.lookup("MyService/local");

		Assert.assertEquals(myService.calculate(2d).longValue(), 12l);
	}
}
