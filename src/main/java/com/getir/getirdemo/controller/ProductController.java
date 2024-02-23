package com.getir.getirdemo.controller;

import com.getir.getirdemo.model.Product;
import com.getir.getirdemo.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        return productService.addNewProduct(json.getString("name"), json.getString("description"), json.getDouble("price"), json.getInt("stock"), json.getLong("category"), json.getString("img"));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteOldProduct(id);
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @GetMapping("/{categoryId}/products")
    public List<Product> getCategoryProducts(@PathVariable Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
