package ru.intr13.example.jboss.transactionalCache;

import javax.naming.InitialContext;
import javax.transaction.TransactionSynchronizationRegistry;

import org.jboss.embedded.Bootstrap;

import com.arjuna.ats.internal.jta.transaction.arjunacore.TransactionSynchronizationRegistryImple;

public abstract class EjbTestCase {

	private static Bootstrap bootstrap;

	public static void main(String[] args) throws Exception {
		bootstrap = Bootstrap.getInstance();
		bootstrap.bootstrap();
		bootstrap
				.deployResourceBase(TransactionSynchronizationRegistryImple.class);
		bootstrap.deployResourceBase(TestService.class);

		TransactionSynchronizationRegistry tsr = (TransactionSynchronizationRegistry) new InitialContext()
				.lookup("java:comp/TransactionSynchronizationRegistry");
		System.out.println(tsr);
		ITestService testService = (ITestService) new InitialContext()
				.lookup("TestService/local");
		System.out.println(testService.sum(7l, 9l));
		bootstrap.shutdown();
	}
}
