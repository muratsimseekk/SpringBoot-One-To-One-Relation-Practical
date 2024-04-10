package com.murat.bookauthor.Book.and.Author.Relation.repository;

import com.murat.bookauthor.Book.and.Author.Relation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Long> {
}
