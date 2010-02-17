package ru.intr13.jboss.embedded.samples;

import java.util.Hashtable;

import javax.naming.InitialContext;

import junit.framework.TestCase;

import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;

public class EmbeddedEjb3TestCase extends TestCase {

	@Override
	protected void setUp() throws Exception {
		startupEmbeddedJboss();
	}

	@Override
	protected void tearDown() throws Exception {
		shutdownEmbeddedJboss();
	}

	public static void startupEmbeddedJboss() {
		EJB3StandaloneBootstrap.boot(null);
		EJB3StandaloneBootstrap.scanClasspath();
	}

	public static void shutdownEmbeddedJboss() {
		EJB3StandaloneBootstrap.shutdown();
	}

	public void testEJBs() throws Exception {

		InitialContext ctx = getInitialContext();
		IService local = (IService) ctx.lookup("Service/local");

		System.out.print(local.sayHello("Hello!"));

	}

	public static InitialContext getInitialContext() throws Exception {
		Hashtable<String, String> props = getInitialContextProperties();
		return new InitialContext(props);
	}

	private static Hashtable<String, String> getInitialContextProperties() {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("java.naming.factory.initial",
				"org.jnp.interfaces.LocalOnlyContextFactory");
		props.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		return props;
	}

	public static void main(String[] args) {
		startupEmbeddedJboss();
		shutdownEmbeddedJboss();
	}
}
