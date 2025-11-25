package com.aadiandjava.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aadiandjava.entity.User;

public interface UserRpository extends JpaRepository<User,Integer>{

}
