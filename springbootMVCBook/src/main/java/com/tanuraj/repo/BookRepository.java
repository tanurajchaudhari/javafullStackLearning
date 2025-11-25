package com.tanuraj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanuraj.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
