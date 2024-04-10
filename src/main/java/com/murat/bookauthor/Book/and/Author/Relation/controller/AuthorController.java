package com.murat.bookauthor.Book.and.Author.Relation.controller;

import com.murat.bookauthor.Book.and.Author.Relation.dto.AuthorDto;
import com.murat.bookauthor.Book.and.Author.Relation.entity.Author;
import com.murat.bookauthor.Book.and.Author.Relation.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {


    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping("/")
    public AuthorDto save(@RequestBody Author author){
        return authorService.save(author);
    }

    @GetMapping("/")
    public List<AuthorDto> findAll(){
        return authorService.findAll();
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable Long id){
        return authorService.delete(id);
    }


}
