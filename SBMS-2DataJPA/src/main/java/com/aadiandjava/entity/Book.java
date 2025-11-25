package com.aadiandjava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="book_table")
@Data // getter setter toString equals hashCode
@AllArgsConstructor
@NoArgsConstructor

public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//MySQL-Identity, oracle-	sequence, unknown-Auto
	private Integer bookId;//Mysql will generate the value automatically
	private String bookName;
	private String bookAuthor;
	private Double bookPrice;
	private Integer bookQuantity;
	

}
