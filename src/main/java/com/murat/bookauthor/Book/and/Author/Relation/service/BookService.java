package com.murat.bookauthor.Book.and.Author.Relation.service;

import com.murat.bookauthor.Book.and.Author.Relation.dto.BookDto;
import com.murat.bookauthor.Book.and.Author.Relation.entity.Book;

import java.util.List;

public interface BookService {

    BookDto save (Book book);

    List<BookDto> findAll();

    BookDto delete ( Long id) ;

}
