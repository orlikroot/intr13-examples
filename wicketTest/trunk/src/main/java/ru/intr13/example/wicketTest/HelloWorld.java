package ru.intr13.example.wicketTest;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HelloWorld extends WebPage {
	public HelloWorld() {
		add(new Label("message", "kva"));
		add(new HelloWorldBorder("helloWorldBorder"));
	}
}