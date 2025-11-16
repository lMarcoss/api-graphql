package com.example.demo;

import ch.qos.logback.core.util.StringUtil;
import com.example.demo.api.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication implements CommandLineRunner {


    @Autowired
    private ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {

        for (String s : List.of("Impresora", "Mouse", "Teclado")) {
            productoRepository.save(Product.builder().nombre(s).precio("12").build());
            log.info("Se ha creado el producto: {}", s);
        }
    }
}
