package daniel.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import daniel.bookclub.models.Book;
import daniel.bookclub.models.User;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    Book findByIdIs(Long id);

}
