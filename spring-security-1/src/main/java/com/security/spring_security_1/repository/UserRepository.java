package com.security.spring_security_1.repository;

import com.security.spring_security_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String user);
}
