package org.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Cart {

    private static Map<Product, Integer> items = new HashMap<>();

    public Cart() {}

    public void addProduct(Product product, Integer quantity) {
        items.put(product, quantity);
    }

    public int size() {
        return items.size();
    }

    public void removeProduct(Product product, Integer quantity) {
        Integer findQuantity = getQuantity(product);
        if (findQuantity == null) {
            throw new NoSuchElementException("product를 찾을 수 없습니다.");
        }
        if (findQuantity < quantity) {
            throw new IndexOutOfBoundsException("현재 수량보다 많이 주문할 수 없습니다.");
        }
        items.put(product, findQuantity - quantity);
    }

    public Integer getQuantity(Product product) {
        return items.get(product);
    }

    public void showItems() {
        StringBuilder sb = new StringBuilder();
        sb.append("내 장바구니 목록: ");

        Iterator<Product> iterator = items.keySet().iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            sb.append(product.getName()).append(" ").append(items.get(product)).append("개");
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}