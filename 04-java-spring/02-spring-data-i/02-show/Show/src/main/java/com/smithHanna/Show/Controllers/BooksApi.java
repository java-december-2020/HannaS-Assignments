package com.smithHanna.Show.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smithHanna.Show.Models.Book;
import com.smithHanna.Show.Services.BookService;

@RestController
public class BooksApi {
    private BookService bService;
    public void Books(BookService bookService){
        this.bService = bookService;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return this.bService.getAllBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(Book book) {
    	return this.bService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bService.findBook(id);
        return book;
    }
}
