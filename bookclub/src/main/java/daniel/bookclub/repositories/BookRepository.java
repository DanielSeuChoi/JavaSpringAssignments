package daniel.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import daniel.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
