package com.concerto.SpringReviseSession.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concerto.SpringReviseSession.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
