package ru.intr13.example.jboss.transactionalCache;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(ITestService.class)
@Stateless(name="TestService")
public class TestService implements ITestService {

	@Override
	public Long sum(Long first, Long second) {
		return first + second;
	}

}
