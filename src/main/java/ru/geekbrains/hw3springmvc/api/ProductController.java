package ru.geekbrains.hw3springmvc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.hw3springmvc.ProductRepository;
import ru.geekbrains.hw3springmvc.model.Product;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public String getAllStudents(Model model) {
        List<Product> products = productRepository.getAll();
        model.addAttribute("products", products);

        return "products";
    }
    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        List<Product> products = productRepository.getProductById(id);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/show_form")
    public String show(){
        return "simple_form";
    }

    @GetMapping("/product_add")
    public String productAdd( @RequestParam String title, @RequestParam int cost) {
        Product product = new Product(title, cost);
        productRepository.addProduct(product);
        return "redirect:/products/all";
    }

}
