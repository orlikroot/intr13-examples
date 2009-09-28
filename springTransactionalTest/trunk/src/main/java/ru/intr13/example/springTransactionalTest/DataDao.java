package ru.intr13.example.springTransactionalTest;

import java.util.Collection;

public interface DataDao {

	Data get(Long id);

	Data save(Data data);

	Collection<Data> find(String text);
}
