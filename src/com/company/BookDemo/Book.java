package com.company.BookDemo;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String name;
    private double price;
    private int year;
    private int month;

    public Book(){}

    public Book(String name, double price, int year, int month) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && year == book.year && month == book.month && name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, year, month);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
