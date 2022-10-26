package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int count;

//    @ManyToMany
//    @JoinTable(
//            name = "oder_book",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "oder_id"))
//    List<Oder> list;

    @OneToMany(mappedBy = "book")
    private List<OderBook> oderBooks;

    public List<OderBook> getOderBooks() {
        return oderBooks;
    }

    public void setOderBooks(List<OderBook> oderBooks) {
        this.oderBooks = oderBooks;
    }

    public Book() {
    }

    public Book(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
