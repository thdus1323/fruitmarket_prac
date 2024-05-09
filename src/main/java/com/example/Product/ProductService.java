package com.example.Product;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;


    //상품 목록보기
    public List<ProductResponse.ListDTO> getProductList() {
     return productRepository.findAll().stream()
             .map(product -> new ProductResponse.ListDTO(product))
             .collect(Collectors.toList());
    }

}
