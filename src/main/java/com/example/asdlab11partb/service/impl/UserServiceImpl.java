package com.example.asdlab11partb.service.impl;

import lombok.AllArgsConstructor;
import org.example.lab6.entity.User;
import org.example.lab6.repo.UserRepository;
import org.example.lab6.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    @Override
    public User newUser(User user) {
        return userRepository.save(user);
    }
}
