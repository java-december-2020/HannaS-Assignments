package com.smithHanna.Show.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smithHanna.Show.Services.BookService;
import com.smithHanna.Show.Models.Book;


@Controller
public class BooksController {
	private BookService bservice;
	
	public BooksController(BookService Bservice) {
		this.bservice = Bservice;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bservice.getAllBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(Book book, Model model) {
		model.addAttribute("book", book );
		return "/books/new.jsp";
	}
	
	@RequestMapping("/books/{id}")
	public String findBookById(Model model, @PathVariable("id") long id) {
		Book book = this.bservice.findBook(id);
		model.addAttribute("book", book);
		return "/books/new2.jsp";
	}
	

	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		}
		else {
			this.bservice.createBook(book);
			return "redirect:/books";
		}
	}
}