package com.tanuraj;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanuraj.entity.Book;
import com.tanuraj.repo.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository brepo;
	
	@GetMapping("/")
	public String loadBookForm() {
		return  "book-form";
	}
	@GetMapping("/search")
	public String searchBook(@RequestParam("bookId")int id ,Model model) {
		Optional<Book> byId = brepo.findById(id);
		if(byId.isPresent()) {
			Book book = byId.get();
			model.addAttribute("book",book);
		}else {
			model.addAttribute("msg","Book Not Found");
		}
		return "book-form";
	}
	
}
