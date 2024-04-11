package com.murat.bookauthor.Book.and.Author.Relation.service;

import com.murat.bookauthor.Book.and.Author.Relation.dto.BookDto;
import com.murat.bookauthor.Book.and.Author.Relation.entity.Author;
import com.murat.bookauthor.Book.and.Author.Relation.entity.Book;
import com.murat.bookauthor.Book.and.Author.Relation.repository.AuthorRepository;
import com.murat.bookauthor.Book.and.Author.Relation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDto save(Book book) {
        // Save the book first
        Book savedBook = bookRepository.save(book);

        // Set the saved book's ID in the author entity
        Author author = book.getAuthor();
        author.setBook(savedBook);
        book.setAuthor(author);

        // Save the author
        authorRepository.save(author);

        // Return the book DTO
        return new BookDto(savedBook.getId(), savedBook.getTitle());
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> bookList = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book book : bookList){
            BookDto bookDto = new BookDto(book.getId(), book.getTitle());
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    public BookDto delete(Long id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isPresent()){
             bookRepository.delete(optional.get());
             return new BookDto(optional.get().getId(), optional.get().getTitle());
        }

        throw new RuntimeException("Cannot find Book with this id : " + id);
    }
}
