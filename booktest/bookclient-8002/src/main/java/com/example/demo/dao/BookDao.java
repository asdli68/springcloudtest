package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer>{

}