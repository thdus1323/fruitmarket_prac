package com.example.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class ProductRepository {
    private final EntityManager em;

    //상품목록보기
    public List<Product> findAll(){
        Query query = em.createNativeQuery("""
select * from product_tb order by product_id desc
""", Product.class);
        return query.getResultList();
    }

    //상품등록
    public void save(ProductRequest.SaveDTO reqDTO) {
        Query query = em.createNativeQuery("insert into puroduct_tb(product_name, product_price, product_qty, created_at) values (?,?,?,now())");
        query.setParameter(1, reqDTO.getProductName());
        query.setParameter(2, reqDTO.getProductPrice());
        query.setParameter(3, reqDTO.getProductQty());
        query.executeUpdate();

    }
}
