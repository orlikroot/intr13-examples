package ru.intr13.example.jboss.transactionalCache;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.TransactionSynchronizationRegistry;

@Remote(ITestService.class)
@Stateless(name = "TestService")
public class TestService implements ITestService {

	@Resource(mappedName = "java:comp/TransactionSynchronizationRegistry")
	TransactionSynchronizationRegistry transactionSynchronizationRegistry;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Long sum(Long first, Long second) throws Exception {
		Long result = (Long) transactionSynchronizationRegistry
				.getResource("kva");
		System.out.println("Old: " + result);

		result = (result == null ? 0 : result) + first;
		transactionSynchronizationRegistry.putResource("kva", result);

		result = (Long) transactionSynchronizationRegistry.getResource("kva");
		System.out.println("Old: " + result);

		result = (result == null ? 0 : result) + second;
		transactionSynchronizationRegistry.putResource("kva", result);

		return result;
	}

}
