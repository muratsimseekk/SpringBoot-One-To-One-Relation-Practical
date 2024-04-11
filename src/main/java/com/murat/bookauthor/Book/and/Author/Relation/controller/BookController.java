package com.murat.bookauthor.Book.and.Author.Relation.controller;


import com.murat.bookauthor.Book.and.Author.Relation.dto.BookDto;
import com.murat.bookauthor.Book.and.Author.Relation.entity.Book;
import com.murat.bookauthor.Book.and.Author.Relation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/")
    public BookDto save(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping("/")
    public List<BookDto> findAll(){
        return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public BookDto delete(@PathVariable Long id){
        return bookService.delete(id);
    }

}
