package cn.kanyun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cn.kanyun.entity.User;

@Repository
public interface UserDao extends JpaRepository<User ,Long> {

}
