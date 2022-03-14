package com.between.test.adapter.jdbc;

import com.between.test.adapter.jdbc.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesJpaRepository extends JpaRepository<Price, Integer> {
    @Query(value = "select p from Price p where :date between p.startDate and p.endDate and p.productId=:product and p.brand.id=:brand order by p.priority desc")
    List<Price> findValidRate(@Param("date") LocalDateTime dateApplication, @Param("product") Integer productId, @Param("brand") Integer brandId);
}
