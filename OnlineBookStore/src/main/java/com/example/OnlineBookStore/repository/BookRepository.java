package com.example.OnlineBookStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnlineBookStore.entity.Book;



public interface BookRepository extends JpaRepository<Book, Integer> {

		
}

