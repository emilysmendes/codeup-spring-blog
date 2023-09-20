package edu.codeup.codeupspringblog.models;

import edu.codeup.codeupspringblog.models.BlogPost;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<BlogPost> blogPosts;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, List<BlogPost> blogPosts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.blogPosts = blogPosts;
    }

    public User(long id, String username, String email, String password, List<BlogPost> blogPosts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.blogPosts = blogPosts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
}