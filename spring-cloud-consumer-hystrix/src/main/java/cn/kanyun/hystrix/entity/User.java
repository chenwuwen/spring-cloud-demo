package cn.kanyun.hystrix.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
/**
 * @author KANYUN
 */
@Builder
@Data
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


}
