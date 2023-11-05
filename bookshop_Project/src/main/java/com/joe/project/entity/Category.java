package com.joe.project.entity;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "category",
               cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Book> books;


    public Category() {
    }

    public Category(String name){
        this.name = name;
    }

    public Category(String name, List<Book> books) {
      //  this.id = id;
        this.name = name;
        this.books = books;
    }
}
