package com.security.spring_security_1.service;

import com.security.spring_security_1.model.User;
import com.security.spring_security_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailService implements UserDetailsService {


    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =userRepository.findByName(username);

//       if(user == null){
//           throw new UsernameNotFoundException("user not found");
//       }
        if(Objects.isNull(user)) {
            System.out.println("User not available");
            throw new UsernameNotFoundException("User not found");
        }
       return new CustomUserDetails(user);
    }
}
