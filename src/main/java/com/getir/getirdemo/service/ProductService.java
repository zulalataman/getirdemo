package com.getir.getirdemo.service;

import com.getir.getirdemo.model.Category;
import com.getir.getirdemo.model.Product;
import com.getir.getirdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addNewProduct(String name, String description, Double price, int stock, Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId).orElseThrow(() -> new RuntimeException("Kategori bulunamadı."));

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setCategory(category);

        return productRepository.save(product);
    }

    public void deleteOldProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product productToUpdate = getProductById(id).orElseThrow(() -> new RuntimeException("Ürün bulunamadı."));

        Category category = categoryService.getCategoryById(updatedProduct.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı."));

        productToUpdate.setName(updatedProduct.getName());
        productToUpdate.setDescription(updatedProduct.getDescription());
        productToUpdate.setPrice(updatedProduct.getPrice());
        productToUpdate.setStock(updatedProduct.getStock());
        productToUpdate.setCategory(category);

        return productRepository.save(productToUpdate);
    }
}
