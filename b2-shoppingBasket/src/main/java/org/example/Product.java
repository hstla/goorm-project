package org.example;

import java.util.Objects;

public class Product {
    private static Long keyCounter = 0L;
    private Long key;

    private String name;
    private int price;

    public Product(String name, int price) {
        this.key = keyCounter++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Long getKey() {
        return key;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(this.getKey(), ((Product) o).getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(key * 123 + this.name.length() + this.price);
    }
}
