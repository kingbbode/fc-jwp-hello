package com.kingbbode.repository;

import com.kingbbode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
