package daniel.electronic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import daniel.electronic.models.Product;
import daniel.electronic.models.Category;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    Product findByIdIs(Long id);

    Optional<Product> findById(Long id);

    List<Product> findAllByCategories(Category category);

    List<Product> findByCategoriesNotContains(Category category);
}
