package com.smithHanna.Show.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smithHanna.Show.Models.Book;
import com.smithHanna.Show.Services.BookService;


@Controller
public class BooksController {

	private BookService bService; 
	
	public BooksController(BookService BService) {
		this.bService = BService; 
	}
	
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bService.findAllBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") int index) {
		Book book = bService.findBookByIndex(index);
		model.addAttribute("book", book);
		return "/books/showBook.jsp"; 
	}
	
	@RequestMapping("books/new")
	public String newBook(Book book, Model model) {
		model.addAttribute("book", book);
		return "/books/new.jsp"; 
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "/books/showBook.jsp";

		}else {
			bService.createBook(book);
			return "redirect:/books"; 
		}
	
	}
	
	@RequestMapping("/books/edit/{id}")
	public String findBookById(Model model, @PathVariable("id") Long id) {
		Book book = this.bService.getBookById(id);
		model.addAttribute("book", book);
		return "/books/showBook.jsp";
	}
	
	  @RequestMapping("/books/edit/{id}")
	    public String editBook(@PathVariable("id") int id, Model model) {
	        Book book = bService.findBookByIndex(id);
	        if (book != null){
	            model.addAttribute("book", book);
	            return "/books/editBook.jsp";
	        }else{
	            return "redirect:/books";
	        }
	    }
	
	
}