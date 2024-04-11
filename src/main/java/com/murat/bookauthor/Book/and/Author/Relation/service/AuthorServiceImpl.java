package com.murat.bookauthor.Book.and.Author.Relation.service;

import com.murat.bookauthor.Book.and.Author.Relation.dto.AuthorDto;
import com.murat.bookauthor.Book.and.Author.Relation.entity.Author;
import com.murat.bookauthor.Book.and.Author.Relation.repository.AuthorRepository;
import com.murat.bookauthor.Book.and.Author.Relation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{



    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto save(Author author) {
         authorRepository.save(author);
         return new AuthorDto(author.getId(), author.getName(), author.getBook().getTitle() , author.getBook().getId());
    }

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();

        for (Author author : authors){
            AuthorDto authorDto = new AuthorDto(author.getId() , author.getName() , author.getBook().getTitle() , author.getBook().getId());
            authorDtos.add(authorDto);
        }
        return authorDtos;
    }

    @Override
    public Author delete(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()){
         authorRepository.delete(author.get());
         return author.get();
        }
        throw new RuntimeException("Cannot find Author with this id : " + id);
    }
}
