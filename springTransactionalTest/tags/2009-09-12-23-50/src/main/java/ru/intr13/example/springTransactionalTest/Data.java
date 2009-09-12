package ru.intr13.example.springTransactionalTest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data implements Serializable {

	private static final long serialVersionUID = 5244126323984055240L;

	private Long id;

	private String text;

	public Data() {
		super();
	}

	public Data(String text) {
		super();
		this.text = text;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
