package com.security.spring_security_1.service;

import com.security.spring_security_1.model.User;
import com.security.spring_security_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
//        user.setPassword(bCryptPasswordEncoder
//                .encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User loginUser(String user){
        return userRepository.findByName(user);
    }
}
