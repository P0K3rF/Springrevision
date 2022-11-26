package com.concerto.SpringReviseSession;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.concerto.SpringReviseSession.entity.Book;
import com.concerto.SpringReviseSession.entity.User;
import com.concerto.SpringReviseSession.repo.UserRepository;
import com.concerto.SpringReviseSession.service.BookService;

@SpringBootApplication
public class SpringReviseSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReviseSessionApplication.class, args);
	}

	@Autowired
	BookService bookService;

	@Autowired
	UserRepository repository;

//	 @Bean
	public void setUP() {
		/*
		 * bookService.insertBook(new Book(5, "Unknown Achebe", "Achaemenid Empire",
		 * "images/the-book-of-job.jpg", "Hebrew",
		 * "https://en.wikipedia.org/wiki/Things_Fall_Apart", 176, "The Book If job",
		 * 600)); bookService.insertBook(new Book(6, "Jane Austen", "United Kingdom",
		 * "images/pride-and-prejudice.jpg", "English",
		 * "https://en.wikipedia.org/wiki/Things_Fall_Apart", 226,
		 * "Pride and Prejudice", 1813)); bookService.insertBook(new Book(7,
		 * "Honoré de Balzac", "France", "images/le-pere-goriot.jpg", "French",
		 * "https://en.wikipedia.org/wiki/Things_Fall_Apart", 443, "Le Père Goriot",
		 * 1835)); bookService.insertBook( new Book(8, "Samuel Beckett",
		 * "Republic of Ireland", "images/molloy-malone-dies-the-unnamable.jpg",
		 * "French, English", "https://en.wikipedia.org/wiki/Things_Fall_Apart", 256,
		 * "Molloy, Malone Dies, The Unnamable, the trilogy", 1952));
		 * bookService.insertBook(new Book(9, "Giovanni Boccaccio", "Italy",
		 * "images/the-decameron.jpg", "Italian",
		 * "https://en.wikipedia.org/wiki/Things_Fall_Apart", 1024, "The Decameron",
		 * 1351));
		 */

		/*
		 * User entity = new User("abc", "abc", "abc@test.com", "1212121212");
		 * List<Integer> wishlist = Arrays.asList(5, 6); entity.setWishlist(wishlist);
		 * repository.save(entity); repository.save(new User("pqr", "pqr",
		 * "pqr@test.com", "3434343434"));
		 */
		
		
		
		
		System.out.println(this.repository.findById("abc").get().getWishlist());

	}
}
