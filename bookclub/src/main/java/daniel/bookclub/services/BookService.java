package daniel.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daniel.bookclub.models.Book;
import daniel.bookclub.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public Book createPost(Book book) {
        return bookRepo.save(book);
    }

    public Book update(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> allPost() {
        return bookRepo.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> optBook = bookRepo.findById(id);
        if (optBook.isPresent()) {
            return optBook.get();
        } else {
            return null;
        }
    }

    public void delete(Book book) {
        bookRepo.delete(book);
    }

}
