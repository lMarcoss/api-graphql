package com.example.demo.api;

import com.example.demo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Product, String> {



}
