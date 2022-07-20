package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;

@Service
public class BookService {
	
	@Autowired
	public BookDao bookDao;
	
	public List<Book> getBook(){
		return bookDao.findAll();
	}
	
	public List<Book> createBook(Book book){
		bookDao.save(book);
		return getBook();
	}

}
