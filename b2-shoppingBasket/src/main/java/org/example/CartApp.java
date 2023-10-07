package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CartApp {

    public static void main(String[] args) {
        // 상품 목록 생성
        Product milk = new Product("우유", 10000);
        Product coll = new Product("지방", 10000);
        Set<Product> productSet = new HashSet<>();

        //상품 클래스를 생성하여 상품목록에 넣는다.
        productSet.add(milk);
        productSet.add(milk);
        productSet.add(coll);

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();
        myCart.addProduct(milk, 2);
        myCart.addProduct(coll, 2);

        // 상품을 장바구니에 추가
        myCart.addProduct(milk, 2);

        // 상품을 장바구니에서 제거
        myCart.removeProduct(milk, 1);

        // 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        myCart.showItems();
    }
}
