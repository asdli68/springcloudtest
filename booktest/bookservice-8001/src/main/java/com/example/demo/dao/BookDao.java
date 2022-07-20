package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer>{
	
	@Query(value = "select * from Book b where b.price > 150.0"
			, nativeQuery=true)
	List<Book> findBook();
	
}