package com.murat.bookauthor.Book.and.Author.Relation.service;

import com.murat.bookauthor.Book.and.Author.Relation.dto.AuthorDto;
import com.murat.bookauthor.Book.and.Author.Relation.entity.Author;

import java.util.List;

public interface AuthorService {

    AuthorDto save(Author author);
    List<AuthorDto> findAll();

    Author delete (Long id ) ;



}
