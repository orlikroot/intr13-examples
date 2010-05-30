package ru.intr13.example.jboss.ejb3.impl;

import static java.lang.System.out;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import ru.intr13.example.jboss.ejb3.api.IConstantsService;
import ru.intr13.example.jboss.ejb3.api.IMyService;
import ru.intr13.example.jboss.ejb3.api.IMyServiceRemote;

@Stateless(name = "MyService")
@Remote(IMyServiceRemote.class)
@Local(IMyService.class)
public class MyService implements IMyServiceRemote {

	@EJB
	IConstantsService constantsService;

	@Override
	public Double calculate(Double radius) throws Exception {
		Double pi = constantsService.getPi();
		Double result = pi * radius * radius;
		out.println("" + pi + " * " + radius + " * " + radius + " = " + result);
		return result;
	}

}
