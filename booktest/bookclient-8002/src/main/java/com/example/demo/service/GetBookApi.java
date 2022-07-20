package com.example.demo.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Book;

@FeignClient(name = "getbookprovider")
public interface GetBookApi {
	
	@GetMapping("/getBook")
	public List<Book> getBook();

}
