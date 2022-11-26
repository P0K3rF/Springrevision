package com.concerto.SpringReviseSession.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concerto.SpringReviseSession.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
