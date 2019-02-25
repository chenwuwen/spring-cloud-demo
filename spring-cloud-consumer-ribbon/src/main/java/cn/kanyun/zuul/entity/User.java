package cn.kanyun.zuul.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String username;
    private char sex;
    private Short age;

    public User() {
    }

    public User(Long id, String username, char sex, Short age) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }
}
