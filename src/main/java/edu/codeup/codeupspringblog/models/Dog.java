package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT")
    private Long id;

    @Column(columnDefinition = "tinyint(3) unsigned")
    private Long age;

    @Column(columnDefinition = "varchar(200)")
    private String name;

    @Column(columnDefinition = "char(2) DEFAULT 'XX'")
    private String resideState;

    public Dog(){

    }

    public Dog(Long id, Long age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}