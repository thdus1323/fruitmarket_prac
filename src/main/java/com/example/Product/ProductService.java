package com.example.Product;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //상품 등록하기
    @Transactional
    public void addProduct(ProductRequest.SaveDTO reqDTO){
        productRepository.save(reqDTO);
    }

    //상품 상세보기
    public ProductResponse.DetailDTO getProductDetail(Integer productId){
        Product product = productRepository.findById(productId);
        return new ProductResponse.DetailDTO(product);
    }

    public Product findById(Integer productId) {
        Product product = productRepository.findById(productId);
        return product;
    }

    //상품 수정
    @Transactional
    public void changeProduct(Integer productId, ProductRequest.UpdateDTO requestDTO) {
        productRepository.updateByProId(productId,requestDTO);
    }
}
