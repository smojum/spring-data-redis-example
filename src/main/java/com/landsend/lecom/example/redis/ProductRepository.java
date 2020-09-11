package com.landsend.lecom.example.redis;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findByValue(String value);
}
