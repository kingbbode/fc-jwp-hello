package com.kingbbode.service;

import com.kingbbode.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
public interface UserService {
    User get(long idx);

    List<User> getAll();

    void save(User user);

    void update(Long id, User user);

    boolean login(String userId, String password, HttpSession httpSession);
}
