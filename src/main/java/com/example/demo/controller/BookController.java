package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Author;
import com.example.demo.service.BookService;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // Display the form to add a new book
    @GetMapping("/book/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());  // Add authors to the model for selection
        return "add-book";
    }

    // Handle form submission to save the new book
    @PostMapping("/book/add")
    public String addBook(Book book) {
        Author author = authorService.getAuthorById(book.getAuthor().getId());  // Fetch the Author object from the database
        book.setAuthor(author);  // Set the author in the book
        bookService.addBook(book);  // Add the book to the database
        return "redirect:/books";  // Redirect to the list of books page
    }

}
