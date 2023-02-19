package daniel.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import daniel.bookclub.models.Book;
import daniel.bookclub.models.User;
import daniel.bookclub.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public Book createPost(Book book) {
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

}
