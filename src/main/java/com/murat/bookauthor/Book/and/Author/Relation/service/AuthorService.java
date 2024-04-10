package com.murat.bookauthor.Book.and.Author.Relation.service;

import com.murat.bookauthor.Book.and.Author.Relation.entity.Author;

import java.util.List;

public interface AuthorService {

    Author save(Author author);
    List<Author> findAll();

    Author delete (Long id ) ;



}
