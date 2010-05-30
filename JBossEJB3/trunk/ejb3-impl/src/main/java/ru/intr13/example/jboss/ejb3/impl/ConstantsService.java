package ru.intr13.example.jboss.ejb3.impl;

import static java.lang.Math.PI;

import javax.ejb.Local;
import javax.ejb.Stateless;

import ru.intr13.example.jboss.ejb3.api.IConstantsService;

@Stateless(name = "ConstantsService")
@Local(IConstantsService.class)
public class ConstantsService implements IConstantsService {

	@Override
	public Double getPi() throws Exception {
		return PI;
	}

}
