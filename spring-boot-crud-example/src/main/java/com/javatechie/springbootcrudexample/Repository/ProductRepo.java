package com.javatechie.springbootcrudexample.Repository;

import com.javatechie.springbootcrudexample.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository <Product,Long> {

    Product findByName(String name);

}
