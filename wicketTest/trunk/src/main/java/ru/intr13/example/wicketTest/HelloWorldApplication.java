package ru.intr13.example.wicketTest;

import org.apache.wicket.protocol.http.WebApplication;

public class HelloWorldApplication extends WebApplication {
	public HelloWorldApplication() {

	}

	public Class getHomePage() {
		return HelloWorld.class;
	}
}