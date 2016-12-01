package com.kingbbode.service.Impl;

import com.kingbbode.model.User;
import com.kingbbode.repository.UserRepository;
import com.kingbbode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(long idx) {
        return userRepository.getOne(idx);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(Long id, User updateUser) {
        User user = userRepository.findOne(id);
        user.changeUser(updateUser);
        userRepository.save(user);
    }

    @Override
    public boolean login(String userId, String password, HttpSession httpSession) {
        User user = userRepository.findByUserId(userId);
        if(user == null || !user.isCorrectPassword(password)){
            return false;
        }
        httpSession.setAttribute("loginUser", user);
        return true;
    }
}
