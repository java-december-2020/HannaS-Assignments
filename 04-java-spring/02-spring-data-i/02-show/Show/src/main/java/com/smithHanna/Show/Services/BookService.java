package com.smithHanna.Show.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smithHanna.Show.Models.Book;
import com.smithHanna.Show.repositories.BookRepository;
@Service
public class BookService {
	
 // adding the book repository as a dependency
	
private final BookRepository bookRepo;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepo = bookRepository;
 }
 // returns all the books
 public List<Book> getAllBooks() {
     return this.bookRepo.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return this.bookRepo.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
	 return this.bookRepo.findById(id).orElse(null);
 }
 
}

