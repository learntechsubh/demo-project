package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // Display the form to add a new author
    @GetMapping("/author/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    // Handle form submission to save the new author
    @PostMapping("/author/add")
    public String addAuthor(Author author) {
        authorService.addAuthor(author);  // Add the author to the database
        return "redirect:/";  // Redirect to the index page
    }
}
