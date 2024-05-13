package com.javatechie.springbootcrudexample.Contoller;

import com.javatechie.springbootcrudexample.Entity.Product;
import com.javatechie.springbootcrudexample.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct (@RequestBody Product product){
        return service.saveProduct(product);

    }

    @PostMapping("/addProducts")
    public List<Product> addProducts (@RequestBody List<Product> products){
        return service.saveProducts(products);

    }

    @GetMapping("/Products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/ProductById/{id}")
    public Product findProductById(@PathVariable Long id){
        return service.getProductsById(id);
    }

    @GetMapping("/Product/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductsByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct (@RequestBody Product product){
        return service.updateProduct(product);

    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable Long id){
        return service.deleteProduct(id);

    }




}
