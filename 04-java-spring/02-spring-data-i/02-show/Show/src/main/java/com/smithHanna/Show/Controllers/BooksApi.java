package com.smithHanna.Show.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smithHanna.Show.Models.Book;
import com.smithHanna.Show.Services.BookService;

@RestController
@RequestMapping("/api")
public class BooksApi {

	@Autowired
	private BookService bService; 
	
	//RETURNS ALL BOOKS
    @GetMapping("/books")
    public List<Book> allBooks(){
    	return this.bService.findAllBooks();
    }
	//RETURNS SINGLE BOOK
    @RequestMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
    	return this.bService.getBookById(id);
    	
    }
    //CREATES NEW BOOK BY TAKING INFO FROM FRONT END
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
    	Book book = new Book(title, desc, lang, numOfPages);
    	return this.bService.createBook(book);
    }
    //UPDATES BOOK
    @PutMapping("/books/update/{id}")
    public Book updateBook(@PathVariable("id") Long id, Book updatedBook) {
    	return this.bService.updateBook(updatedBook);
    }
    //DELETES BOOK BY ID
    @DeleteMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
    	this.bService.deleteBook(id);
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = bService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bService.deleteBook(id);
    }
}
    
    

