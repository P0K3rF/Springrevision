package com.concerto.SpringReviseSession.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.SpringReviseSession.entity.Book;
import com.concerto.SpringReviseSession.entity.User;
import com.concerto.SpringReviseSession.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookService bookService;
	
	public boolean saveUser(User user) {
		if(!this.userRepository.existsById(user.getUsername())) {
			this.userRepository.save(user);
			return true;
		}
		throw new EntityExistsException("User with this username already exists");
	}
	
	
	public boolean validateUser(String username,String password) {
		if(this.userRepository.existsById(username)) {
			String userPassword=this.userRepository.findById(username).get().getPassword();
			if(userPassword.equals(password))
			{
				return true;
			}
			
		}
		throw new EntityNotFoundException("Invalid Credentials");
	}
	
	
	public List<Integer> getAllWishlist(String username){
	Optional<User>	optionalUser=this.userRepository.findById(username);
	
	if(optionalUser.isPresent()) {
		return optionalUser.get().getWishlist();
	}
	throw new EntityNotFoundException("No Book present in wishlist");	
	}
	
	
	public List<Book> getAllWishlistBook(String username)
	{
		
		List<Integer> wishlists=this.getAllWishlist(username);
		List<Book> wishlistBooks=new ArrayList<>();
		for(Integer i : wishlists) {
		wishlistBooks.add(this.bookService.getBookById(i));
		}
		return wishlistBooks;
		
	}
	
	
	
	public boolean insertWishlist(String username,int id) {
		List<Integer> wishlists=this.getAllWishlist(username);
		
		Integer bookId=id;
		if(this.bookService.getBookById(id)!=null) {
			
			if(wishlists.stream().noneMatch(bookid->bookid.equals((bookId))))
			{
					User persistentUser=this.userRepository.findById(username).get();
					wishlists.add(id);
					persistentUser.setWishlist(wishlists);
					this.userRepository.save(persistentUser);
					return true;
			
			}
			throw new EntityExistsException("Book Already Exists");
		}
		throw new EntityNotFoundException("No Book present with the given id");
		
		
	}
	
	
	
	
	
	/*
	 * 
	 * public boolean insertWishlist(String username,int id) {
	 * 
	 * User user=this.userRepository.findById(username).get(); }
	 * 
	 * 
	 * public List<Book> getWishlist(String username){
	 * 
	 * }
	 */
	
	/*
	 * public List<Book> getWishlist(String username){ Optional<User>
	 * optionalUser=this.userRepository.findById(username);
	 * if(optionalUser.isPresent()) { return optionalUser.get().getWishlist(); } }
	 */
	
	
}
