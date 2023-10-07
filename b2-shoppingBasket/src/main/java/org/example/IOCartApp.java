package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class IOCartApp {

    public static void main(String[] args) {
        // csv파일에서 상품 목록을 가져온다.
        HashSet<Product> productList = loadProductsListCSV("productList.csv");

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productList) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }
        Iterator<Product> ProductIterator = productList.stream().iterator();

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        int cnt = 1;
        while (ProductIterator.hasNext()) {
            myCart.addProduct(ProductIterator.next(), cnt++);
        }

        // 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        myCart.showItems();
    }


    public static HashSet<Product> loadProductsListCSV(String csvFileName) {
        HashSet<Product> productSet = new HashSet<>();
        try (
            BufferedReader br = new BufferedReader(new FileReader(csvFileName))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    String productName = fields[0].trim();
                    int productPrice = Integer.parseInt(fields[1].trim());
                    Product product = new Product(productName, productPrice);
                    productSet.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productSet;
    }
}
