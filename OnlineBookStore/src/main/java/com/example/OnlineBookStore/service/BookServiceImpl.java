package com.example.OnlineBookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineBookStore.entity.Book;
import com.example.OnlineBookStore.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{
	private BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository theBookRepository) {
		bookRepository = theBookRepository;
	}
	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int theId) {
		Optional<Book> result = bookRepository.findById(theId);
		Book theBook = null;
		
		if(result.isPresent()) {
			theBook = result.get();
		}else {
			throw new RuntimeException("did not find the book" +theId);
	}
		return theBook;
	}

	@Override
	public void save(Book theBook) {
		bookRepository.save(theBook);
		
	}

	@Override
	public void deleteById(int theId) {
		bookRepository.deleteById(theId);
		
	}

}
