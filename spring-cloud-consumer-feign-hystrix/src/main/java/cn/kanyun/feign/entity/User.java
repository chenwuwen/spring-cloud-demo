package cn.kanyun.feign.entity;

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

}
