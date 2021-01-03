package com.smithHanna.Show.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smithHanna.Show.Models.Book;
import com.smithHanna.Show.repositories.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepo; 
	
	public BookService (BookRepository bookRepository) {
		this.bookRepo = bookRepository; 
	}
	
	//Retrieve all
	public List<Book> findAllBooks(){
		return this.bookRepo.findAll();
	}
	//create
	public Book createBook(Book newBook) {
		return this.bookRepo.save(newBook);
	}
	//read
	public Book getBookById(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	//update
	public Book updateBook(Book updatedDog) {
		return this.bookRepo.save(updatedDog);
	}
	//delete
	public void deleteBook(Long id) {
		this.bookRepo.deleteById(id);
	}
	private List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
    
    public List<Book> allBooks() {
        return books;
    }
    
    public Book findBookByIndex(int index) {
        if (index < books.size()){
            return books.get(index);
        }else{
            return null;
        }
    }
    public void updateBook(int id, Book book) {
        if (id < books.size()){
            books.set(id, book);
        }
    }
    
    public void destroyBook(int id) {
        if (id < books.size()){
            books.remove(id);
        }
    }

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book updatedBook = this.bookRepo.findById(id).orElse(null);
		updatedBook.setLanguage(lang);
		updatedBook.setDescription(desc);
		updatedBook.setTitle(title);
		updatedBook.setNumberOfPages(numOfPages);
		return this.bookRepo.save(updatedBook);
		
	}
	
}
