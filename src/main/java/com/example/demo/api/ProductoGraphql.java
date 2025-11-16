package com.example.demo.api;

import com.example.demo.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductoGraphql {

    private final ProductoRepository productoRepository;


    @QueryMapping(name = "products")
    public List<Product> products() {
        return productoRepository.findAll();
    }

}
