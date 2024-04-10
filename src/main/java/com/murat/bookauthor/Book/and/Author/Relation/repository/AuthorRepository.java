package com.murat.bookauthor.Book.and.Author.Relation.repository;

import com.murat.bookauthor.Book.and.Author.Relation.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author , Long> {
}
