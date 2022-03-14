package com.between.test.adapter.jdbc;

import com.between.test.faker.PricesFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PricesJpaAdapterTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PricesJpaRepository pricesJpaRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(pricesJpaRepository).isNotNull();
    }

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test_1_Request_ThenReturnOk() {
        var request = PricesFaker.fakeValidRate1();
        var dateTime = LocalDateTime.parse(request.getDateApplication());

        var result = pricesJpaRepository.findValidRate(
                dateTime,request.getProductId(),request.getBrandId()).get(0);

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test_2_Request_ThenReturnOk() {
        var request = PricesFaker.fakeValidRate2();
        var dateTime = LocalDateTime.parse(request.getDateApplication());

        var result = pricesJpaRepository.findValidRate(
                dateTime,request.getProductId(),request.getBrandId()).get(0);

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test_3_Request_ThenReturnOk() {
        var request = PricesFaker.fakeValidRate3();
        var dateTime = LocalDateTime.parse(request.getDateApplication());

        var result = pricesJpaRepository.findValidRate(
                dateTime,request.getProductId(),request.getBrandId()).get(0);

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    void test_4_Request_ThenReturnOk() {
        var request = PricesFaker.fakeValidRate4();
        var dateTime = LocalDateTime.parse(request.getDateApplication());

        var result = pricesJpaRepository.findValidRate(
                dateTime,request.getProductId(),request.getBrandId()).get(0);

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    void test_5_Request_ThenReturnOk() {
        var request = PricesFaker.fakeValidRate5();
        var dateTime = LocalDateTime.parse(request.getDateApplication());

        var result = pricesJpaRepository.findValidRate(
                dateTime,request.getProductId(),request.getBrandId()).get(0);

        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Test 6: petición a las 21:00 del día 16 del producto 35455 para la brand 2 (ZARA)")
    void test_6_Request_ThenReturnOk() {
        var request = PricesFaker.fakeValidRate6();
        var dateTime = LocalDateTime.parse(request.getDateApplication());

        var result = pricesJpaRepository.findValidRate(
                dateTime,request.getProductId(),request.getBrandId());

        assertThat(result).isEmpty();
    }
}
