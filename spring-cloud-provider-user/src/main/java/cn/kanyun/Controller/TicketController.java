package cn.kanyun.Controller;

import cn.kanyun.dao.UserDao;
import cn.kanyun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userDao.findOne(id);
    }
}
