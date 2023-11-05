package com.joe.project.entity;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private String year;
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;


    public Book(){

    }

    public Book(String title, String year, String authorName, double price, Category category) {
      //  this.id = id;
        this.title = title;
        this.year = year;
        this.authorName = authorName;
        this.price = price;
        this.category = category;
    }

    public Book(String title, String year, String authorName, double price) {
        //  this.id = id;
        this.title = title;
        this.year = year;
        this.authorName = authorName;
        this.price = price;
    }

}
