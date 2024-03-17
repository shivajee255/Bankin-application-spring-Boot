package com.nt.test.service;

import com.nt.test.dto.UserRequest;
import com.nt.test.repository.UserRepository;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {

        return userRepository.save(saveUser(userRequest));

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public  User getUser(int id){
        return userRepository.findByUserId(id);
    }
}