package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public DemoService(AuthorRepository authorRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    public List<Author> getAllAuthors() { return authorRepo.findAll(); }
    public Author saveAuthor(Author author) { return authorRepo.save(author); }
    public Author getAuthorById(Long id) { return authorRepo.findById(id).orElse(null); }

    public List<Book> getAllBooks() { return bookRepo.findAll(); }
    public List<Book> getBooksWithAuthors() { return bookRepo.findAllWithAuthors(); }
    public Book saveBook(Book book) { return bookRepo.save(book); }
    public Book getBookById(Long id) { return bookRepo.findById(id).orElse(null); }
}
