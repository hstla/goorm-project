package org.example;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CartTest {

    @DisplayName("Cart 에 물건을 담는다.")
    @Test
    void addProductTest() {
        // given
        Product milk = new Product("우유", 1000);
        Product orange = new Product("오렌지", 2000);
        Cart cart = new Cart();

        // when
        cart.addProduct(milk, 2);
        cart.addProduct(orange, 3);

        // then
        assertThat(cart.size()).isEqualTo(2);
    }

    @DisplayName("cart에 담긴 물건을 원하는 수량만큼 제거한다.")
    @Test
    void removeProduct() {
        // given
        Product milk = new Product("우유", 1000);
        Cart cart = new Cart();
        cart.addProduct(milk, 2);

        // when
        cart.removeProduct(milk, 2);

        // then
        assertThat(cart.getQuantity(milk)).isEqualTo(0);
    }

    @DisplayName("cart 애 물건이 없으면 NoSuchElementException 를 발생시킨다.")
    @Test
    void removeNoSuchExceptionProduct() {
        // given
        Product milk = new Product("우유", 1000);
        Cart cart = new Cart();

        // when then
        assertThatThrownBy(() -> cart.removeProduct(milk, 1))
            .isInstanceOf(NoSuchElementException.class)
            .hasMessage("product를 찾을 수 없습니다.");
    }

    @DisplayName("cart 애 현재 수량이 없으면 IndexOutOfBoundsException 를 발생시킨다.")
    @Test
    void removeIndexOutExceptionProduct() {
        // given
        Product milk = new Product("우유", 1000);
        Cart cart = new Cart();
        cart.addProduct(milk, 2);

        // when then
        assertThatThrownBy(() -> cart.removeProduct(milk, 3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("현재 수량보다 많이 주문할 수 없습니다.");
    }
}