package com.concerto.SpringReviseSession.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data


@Entity
public class User {
	@Id
	private String username;
	private String password;
	private String email;
	private String phone;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "wishlist", joinColumns = @JoinColumn(name="username"))
	@Column(name="bookid")
	private List<Integer> wishlist;
	@ElementCollection
	@JoinTable(name = "completed", joinColumns = @JoinColumn(name="username"))
	@Column(name="bookid")
	private List<Integer> completed;
	public User(String username, String password, String email, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	
	
	
}
