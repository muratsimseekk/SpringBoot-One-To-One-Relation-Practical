package com.murat.bookauthor.Book.and.Author.Relation.service;

import com.murat.bookauthor.Book.and.Author.Relation.entity.Author;
import com.murat.bookauthor.Book.and.Author.Relation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{



    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
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
