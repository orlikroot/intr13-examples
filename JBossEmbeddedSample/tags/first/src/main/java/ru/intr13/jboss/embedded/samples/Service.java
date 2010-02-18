package ru.intr13.jboss.embedded.samples;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local( { IService.class })
public class Service implements IService, java.io.Serializable {

	private static final long serialVersionUID = -1935688127957567062L;

	@PersistenceContext(unitName = "sampledb")
	private EntityManager em;

	@Override
	public String sayHello(String message) {
		System.out.println(message);
		Data data = new Data(message);
		em.persist(data);
		return "Hello world! - " + data.getId();
	}

}
