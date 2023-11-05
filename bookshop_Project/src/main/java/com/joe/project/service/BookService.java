package com.joe.project.service;

import com.joe.project.dto.BookDTO;
import com.joe.project.entity.Book;
import com.joe.project.reposietpry.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public List<Book> getAll() {            //Read
        return bookRepository.findAll();
    }

    public Optional<Book> getById(int id){  // Read by id
        return bookRepository.findById(id);
    }

    public void save(BookDTO bookDTO){       // Create, Update
        Book book = new Book(bookDTO.getTitle(),
                             bookDTO.getYear(),
                             bookDTO.getAuthorName(),
                             bookDTO.getPrice(),
                             bookDTO.getCategory()
                    );
        book.setId(0);
        bookRepository.save(book);
    }

    public String delete(int id){
        bookRepository.deleteById(id);
        return "Deleted";
    }

}
