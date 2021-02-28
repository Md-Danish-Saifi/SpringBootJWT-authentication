package com.jwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jwt.demo.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


	User findByEmailIgnoreCase(String email);
	User findByName(String name);

}
