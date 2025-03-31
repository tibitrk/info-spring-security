package com.security.spring_security_1.service;

import com.security.spring_security_1.model.User;
import com.security.spring_security_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public User registerUser(User user){
        user.setPassword(bCryptPasswordEncoder
                .encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User loginUser(String user){
        return userRepository.findByName(user);
    }
    public String verify(User user){
        Authentication authenticate
                = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                        user.getName(),user.getPassword())
        );
             //   User isExist = userRepository.findByName(user.getName());
        if (authenticate.isAuthenticated() ) {
            return jwtService.generateToken(user);
        } else {
            return "failure";
        }
    }
}
