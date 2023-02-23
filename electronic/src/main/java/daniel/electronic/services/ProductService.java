package daniel.electronic.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import daniel.electronic.repositories.ProductRepository;
import daniel.electronic.models.Product;
import daniel.electronic.models.Category;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }

    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAssignedProducts(Category category) {
        return productRepository.findAllByCategories(category);
    }

    public List<Product> getUnassignedProducts(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
