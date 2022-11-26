package com.concerto.SpringReviseSession.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.SpringReviseSession.entity.Book;
import com.concerto.SpringReviseSession.repo.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		if(this.bookRepository.count()>0) {			
			return this.bookRepository.findAll();
		}
		throw new EntityNotFoundException("No Book Present");
	}
	
	public Book getBookById(int bookId) {
		Optional<Book> optionalBook=this.bookRepository.findById(bookId);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		throw new EntityNotFoundException("No Book Present");
	}
	
	public boolean insertBook(Book book) {
	
		if(!this.bookRepository.existsById(book.getId())) {			
			this.bookRepository.save(book);
			return true;
		}
		throw new EntityExistsException("Book with this id already exists");
	}
	
}
