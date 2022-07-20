package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;


@RestController
public class ServerController {

	@Autowired
	private BookService bookService;

	//傳回data
	@GetMapping("/getBook")
	public List<Book> getBook(Model model) {
		List<Book> allBookList = bookService.getBook();
		//model.addAttribute("bookList", allBookList);
		return allBookList;
	}
	
}
