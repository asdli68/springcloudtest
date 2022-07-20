package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.ExcelService;
import com.example.demo.service.GetBookApi;

@Controller
public class ClientController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private ExcelService excelService;
	
	@Autowired
	private GetBookApi getBookApi;
	
	@GetMapping("/")
	public String form(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "ClientIndex";
	}
	
	@PostMapping("/form")
	public String newForm(@ModelAttribute Book book, Model model) {
		List<Book> allBookList = bookService.createBook(book);
		Book newBook = new Book();
		model.addAttribute("book", newBook);
		return "redirect:/";
		
	}
	
	@GetMapping("/data")
	public String showData(@ModelAttribute Book book, Model model) {
		List<Book> allBookList = bookService.getBook();
		model.addAttribute("bookList", allBookList);
		return "data";
	}
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, Map<String, Object> map) {
		List<Book> list = null;
		try {
			list = excelService.excelBookList(file.getInputStream());
			if(list == null || list.size() <= 0) {
				//空 
				return "redirect:/";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		//完成
		return "redirect:/";
	}
	
	@GetMapping("/getBook")
	public String getBook(Model model) {
		//System.out.println(getBookApi.getBook());
		model.addAttribute("bookList", getBookApi.getBook());
		return "data";
	}
	
	
}
