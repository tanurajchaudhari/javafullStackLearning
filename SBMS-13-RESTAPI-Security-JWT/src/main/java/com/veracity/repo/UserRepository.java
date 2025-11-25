package com.veracity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veracity.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository  extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
}
