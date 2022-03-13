package com.between.test.adapter.jdbc;

import com.between.test.adapter.jdbc.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PricesJpaRepository extends JpaRepository<Price, Integer> {
    //@Query("select top 1 p from Price p where p.start_date>=?1 and p.end_date<=?1 and p.product_id=?2 and p.brand=?3 order by p.priority desc")
    //Price getPrice(LocalDateTime dateApplication, Integer productId, Integer brandId);
    //@Query("select top 1 p from Price p where ?1 between p.start_date and p.end_date and p.product_id=?2 and p.brand=?3 order by p.priority desc")
    Price findByNameCustomQuery(LocalDateTime dateApplication, Integer productId, Integer brandId);
}
