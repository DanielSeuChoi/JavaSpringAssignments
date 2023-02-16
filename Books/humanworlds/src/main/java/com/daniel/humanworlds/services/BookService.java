package com.daniel.humanworlds.services;

import com.daniel.humanworlds.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.daniel.humanworlds.models.Book;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}
