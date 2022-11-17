package com.example.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String productStatus;
    private int total;
    private Integer status = 1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productType_id" , referencedColumnName = "id")
    private ProductType productType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderProduct_id" , referencedColumnName = "id")
    private OrderProduct order;


    public Product() {
    }

    public Product(int id, String name, double price, String productStatus, int total,
                   Integer status, ProductType productType, OrderProduct order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productStatus = productStatus;
        this.total = total;
        this.status = status;
        this.productType = productType;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public OrderProduct getOrder() {
        return order;
    }

    public void setOrder(OrderProduct order) {
        this.order = order;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
