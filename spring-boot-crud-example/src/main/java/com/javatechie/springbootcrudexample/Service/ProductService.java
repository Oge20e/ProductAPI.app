package com.javatechie.springbootcrudexample.Service;

import com.javatechie.springbootcrudexample.Entity.Product;
import com.javatechie.springbootcrudexample.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;

    public Product saveProduct(Product product){
      return  repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return  repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductsById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductsByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(Long id){
        repository.deleteById(id);
        return "Product removed " + id;
    }

    public Product updateProduct (Product product){
        Product existingProduct= repository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
