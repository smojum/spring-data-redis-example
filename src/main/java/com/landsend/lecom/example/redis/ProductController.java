package com.landsend.lecom.example.redis;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("save")
    public Product save() {
        Product product = new Product();
        product.setValue("Three");
        Sku sku = new Sku();
        sku.setSkuId(String.valueOf(Math.random()));
        sku.setDescription("Sku Description");
        product.setSku(sku);
        Product output = repository.save(product);
        return output;
    }

    @GetMapping("find-all")
    public Iterable<Product> get() {
        return repository.findAll();

    }

    @GetMapping("find/{id}")
    public Optional<Product> get(@PathVariable("id") String id) {
        return repository.findById(id);
    }
    @GetMapping("find/value/{value}")
    public List<Product> getValue(@PathVariable("value") String value) {
        return repository.findByValue(value);
    }

    @GetMapping("save-all")
    public Iterable<Product> saveAll() {
        Product product1 = new Product();
        product1.setValue("All");
        Sku sku1 = new Sku();
        sku1.setSkuId(String.valueOf(Math.random()));
        sku1.setDescription("Sku Description");
        product1.setSku(sku1);

        Product product2 = new Product();
        product2.setValue("All");
        Sku sku2 = new Sku();
        sku2.setSkuId(String.valueOf(Math.random()));
        sku2.setDescription("Sku Description");
        product1.setSku(sku2);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        Iterable<Product> output = repository.saveAll(products);
        return output;
    }

}
