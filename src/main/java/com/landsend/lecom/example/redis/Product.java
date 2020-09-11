package com.landsend.lecom.example.redis;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash
public class Product {
    @Id
    private String id;
    private String value;
    private Sku sku;

}
