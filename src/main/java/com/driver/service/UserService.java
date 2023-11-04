package com.driver.service;

import com.driver.model.User;
import com.driver.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo=new UserRepo();


    public int createUser(User user){
        return userRepo.save(user);
    }
}
