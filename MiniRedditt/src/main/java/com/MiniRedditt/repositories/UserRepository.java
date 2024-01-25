package com.MiniRedditt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MiniRedditt.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
