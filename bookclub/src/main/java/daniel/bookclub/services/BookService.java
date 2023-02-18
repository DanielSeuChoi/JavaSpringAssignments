package daniel.bookclub.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import daniel.bookclub.models.Book;
import daniel.bookclub.repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public void createPost(Book book) {
        bookRepo.save(book);
    }

    public List<Book> allPost() {
        return bookRepo.findAll();
    }
}
