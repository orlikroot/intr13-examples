package ru.intr13.example.jboss.ejb3.client;

import java.util.Properties;

import javax.naming.InitialContext;

import ru.intr13.example.jboss.ejb3.api.IMyServiceRemote;

public class MyClient {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		p.put("java.naming.provider.url", "jnp://localhost:1099");
		p.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");

		InitialContext initialContext = new InitialContext(p);
		IMyServiceRemote testService = (IMyServiceRemote) initialContext
				.lookup("jboss-ejb3/MyService/remote");
		Double result = testService.calculate(5d);
		System.out.println(result);

	}

}
