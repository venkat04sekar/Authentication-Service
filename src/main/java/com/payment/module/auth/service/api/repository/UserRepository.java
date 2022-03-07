package com.payment.module.auth.service.api.repository;


import com.payment.module.auth.service.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUserName(String username);
}
