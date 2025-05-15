package org.comic.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;


public class Comic {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private int pageCount;
    private String genre;
    private int year;
    private double costPrice;
    private double sellingPrice;

    @JsonProperty("isSequel")
    private boolean isSequel;

    @JsonProperty("isOnSale")
    private boolean isOnSale;

    private double discount;

    @JsonProperty("isReserved")
    private boolean isReserved;

    private String reservedBy;
    private int salesCount;

    // Конструктор по умолчанию (обязателен для Jackson)
    public Comic() {}

    public Comic(Long id, String title, String author, String publisher,
                 int pageCount, String genre, int year,
                 double costPrice, double sellingPrice) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.genre = genre;
        this.year = year;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.isOnSale = false;
        this.discount = 0.0;
        this.isReserved = false;
        this.reservedBy = null;
        this.salesCount = 0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isSequel() {
        return isOnSale;
    }

    public void setSequel(boolean sequel) {
        isOnSale = sequel;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }
}

