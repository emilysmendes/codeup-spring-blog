package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity

//we did the line below cause the table was singular and we normally want plural because spring will name the columns the singular version of the title you entered for the table name, obviously that will confuse us in the end so we change the name

@Table(name = "contacts")

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private String email;


    public Contact(){
    }

    public Contact(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}