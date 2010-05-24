package ru.intr13.example.jboss.transactionalCache;

import java.util.Properties;

import javax.naming.InitialContext;

public class Test {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		p.put("java.naming.provider.url", "jnp://localhost:1099");
		p.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");

		InitialContext initialContext = new InitialContext(p);
		ITestService testService = (ITestService) initialContext
				.lookup("jboss-tr-cache/TestService/remote");
		Long result = testService.sum(2l, 3l);
		System.out.println(result);

	}

}
