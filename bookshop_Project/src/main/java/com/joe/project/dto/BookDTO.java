package com.joe.project.dto;

import com.joe.project.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String title;
    private String year;
    private String authorName;
    private Double price;
    private Category category;

    public BookDTO(String title, String year, String authorName, Double price) {
        this.title = title;
        this.year = year;
        this.authorName = authorName;
        this.price = price;
    }
}
