package com.example.OnlineBookStore.service;

import java.util.List;

import com.example.OnlineBookStore.entity.Book;

public interface BookService {
	List<Book> findAll();

	Book findById(int theId);

	void save(Book theBook);

	void deleteById(int theId);
}
