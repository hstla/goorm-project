package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

    @DisplayName("product 를 생성하여 key 값이 제대로 들어갔는지 확인한다.")
    @Test
    void countKey() {
        // given when
        Product milk1 = new Product("우유", 10000);
        Product milk2 = new Product("우유", 10000);

        // then
        assertThat(milk1.getKey()).isEqualTo(0L);
        assertThat(milk2.getKey()).isEqualTo(1L);
    }

    @DisplayName("제품의 이름과 가격은 같지만 키값이 달라 False를 반환한다.")
    @Test
    void keyEquals() {
        // given
        Product milk1 = new Product("우유", 10000);
        Product milk2 = new Product("우유", 10000);

        // when
        boolean result = milk1.equals(milk2);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("HashSet안에 같은 제품이 중복되어 들어가지 않는다.")
    @Test
    void testHashCode() {
        // given
        Product milk1 = new Product("우유", 10000);
        Product milk2 = new Product("우유", 10000);
        Set<Product> set = new HashSet<>();

        // when
        set.add(milk1);
        set.add(milk1);
        set.add(milk2);

        // then
        assertThat(set.size()).isEqualTo(2);
    }
}