package com.smithHanna.Show.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		List<Book> books = bService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") int index) {
		Book book = bService.findBookByIndex(index);
		model.addAttribute("book", book);
		return "/books/showBook.jsp"; 
	}
	
	/*@RequestMapping("books/new")
	public String newBook(Book book, Model model) {
		model.addAttribute("book", book);
		return "/books/new.jsp"; 
	}*/
	
	@PostMapping(value="/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "/books/new.jsp";

		}else {
			bService.createBook(book);
			return "redirect:/books"; 
		}
	
	}
	
	  @GetMapping("/books/edit/{id}")
	    public String editBook(@PathVariable("id") int id, Model model) {
	        Book book = this.bService.findBookByIndex(id);
	        if (book != null){
	            model.addAttribute("book", book);
	            return "/books/editBook.jsp";
	        }else{
	            return "redirect:/books";
	        }
	    }
	   
	  @PostMapping("/books/edit/{id}")
	    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "editBook.jsp";
	        }else{
	            bService.updateBook(id, book);
	            return "redirect:/books";
	        }
	 } 
	   @RequestMapping(value="/books/delete/{id}")
	    public String destroyBook(@PathVariable("id") int id) {
	    	this.bService.destroyBook(id);
	    	return "redirect:/books";
	    }
	   @RequestMapping("/books/new")
	    public String newBook(@ModelAttribute("book") Book book) {
	        return "/books/newBook.jsp";
	    }
	   
	   @PostMapping("/books/new")
	    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/books/newBook.jsp";
	        }else{
	            // Add the book
	        	this.bService.addBook(book);
	            return "redirect:/books";
	        }
	    }
}
	
	
