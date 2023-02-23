package daniel.electronic.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import daniel.electronic.models.Category;
import daniel.electronic.models.Product;
import daniel.electronic.services.CategoryService;
import daniel.electronic.services.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.allProducts());
        model.addAttribute("category", categoryService.alLCategory());
        return "index.jsp";
    }

    @GetMapping("/product/new")
    public String newProduct(@ModelAttribute("product") Product product, Model model) {
        return "newProduct.jsp";
    }

    @PostMapping("/product/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "newProduct.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/";
        }
    }

    @GetMapping("/category/new")
    public String newCategory(@ModelAttribute("category") Category category) {

        return "newCategory.jsp";
    }

    @PostMapping("/category/new")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";
        } else {
            categoryService.createCategory(category);
            return "redirect:/";
        }
    }

    @GetMapping("/products/{id}")
    public String oneProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("assignedCategories", categoryService.getAssignedCategories(product));
        model.addAttribute("unassignedCategories", categoryService.getUnassignCategories(product));
        return "oneProduct.jsp";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable("id") Long id, @RequestParam(value = "categoryId") Long categoryId,
            Model model) {
        Product product = productService.findById(id);
        Category category = categoryService.findById(categoryId);
        product.getCategories().add(category);
        productService.updateProduct(product);
        return "redirect:/products/" + id;
    }
}
