package com.concerto.SpringReviseSession.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.SpringReviseSession.dto.LoginDto;
import com.concerto.SpringReviseSession.dto.Wishlistdto;
import com.concerto.SpringReviseSession.entity.Book;
import com.concerto.SpringReviseSession.entity.User;
import com.concerto.SpringReviseSession.service.BookService;
import com.concerto.SpringReviseSession.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody User user)
	{
		try {
			this.userService.saveUser(user);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		}catch(EntityExistsException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> validateLogin(@RequestBody LoginDto dto){
		try {
			
			this.userService.validateUser(dto.getUsername(), dto.getPassword());
			return new ResponseEntity<>("Login Succesful", HttpStatus.OK);
			
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/books")
	public ResponseEntity<Object> getAllBooks(){
		try {
		
			return new ResponseEntity<>(this.bookService.getAllBooks(), HttpStatus.OK);
			
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@GetMapping("books/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable int id){
		try
		{
			return new ResponseEntity<>(this.bookService.getBookById(id),HttpStatus.OK);	
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	  @PostMapping("wishlist")
	 	public ResponseEntity<Object> insertWishlist(@RequestBody Wishlistdto wishlistdto){
		
		  Map<String, String> data=new HashMap<>();
		  
		  try {
		 this.userService.insertWishlist(wishlistdto.getUsername(), wishlistdto.getId());
			 return new ResponseEntity<>("Succesful", HttpStatus.OK);
		  }catch(EntityExistsException  | EntityNotFoundException e1) {
			  data.put("Error", e1.getMessage());
			return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		  }
	  }
	  
	  
	  @GetMapping("/wishlist/{username}")
	  public ResponseEntity<Object> getAllWishlist(@PathVariable String username)
	  {
		  try {
			  return new ResponseEntity<>(this.userService.getAllWishlistBook(username),HttpStatus.OK);
			  
		  }catch(EntityNotFoundException e) {
			  return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		  }
	  }
	  
	
	/*
	 * @PostMapping("/user/wishlist") public ResponseEntity<Object>
	 * getBooksFromWishList(){
	 * 
	 * }
	 */
	
	
}
