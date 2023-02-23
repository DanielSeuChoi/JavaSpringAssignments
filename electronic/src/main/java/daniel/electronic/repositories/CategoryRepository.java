package daniel.electronic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import daniel.electronic.models.Category;
import daniel.electronic.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    Category findByIdIs(Long id);

    Optional<Category> findById(Long id);

    List<Category> findAllByProducts(Product product);

    List<Category> findByProductsNotContains(Product product);
}
