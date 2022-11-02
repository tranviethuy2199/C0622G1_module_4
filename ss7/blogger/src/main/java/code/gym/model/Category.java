package code.gym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Blogger> bloggers;

    public Category() {
    }

    public Category(int id, String name,  Set<Blogger> bloggers) {
        this.id = id;
        this.name = name;
        this.bloggers = bloggers;
    }


    public Set<Blogger> getBloggers() {
        return bloggers;
    }

    public void setBloggers(Set<Blogger> bloggers) {
        this.bloggers = bloggers;
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

    public Set<Blogger> getBlogers() {
        return bloggers;
    }

    public void setBlogers(Set<Blogger> blogers) {
        this.bloggers = blogers;
    }
}
