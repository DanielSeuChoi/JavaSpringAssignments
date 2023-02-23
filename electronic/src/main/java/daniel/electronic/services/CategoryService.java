package daniel.electronic.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import daniel.electronic.repositories.CategoryRepository;
import daniel.electronic.models.Category;
import daniel.electronic.models.Product;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> alLCategory() {
        return categoryRepository.findAll();
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    public List<Category> getAssignedCategories(Product product) {
        return categoryRepository.findAllByProducts(product);
    }

    public List<Category> getUnassignCategories(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }
}
