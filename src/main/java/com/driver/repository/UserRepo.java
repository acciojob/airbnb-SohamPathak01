package com.driver.repository;

import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class UserRepo {
    private final Map<Integer, User> userDB=new HashMap<>();

    public int save(User user){
        userDB.put(user.getaadharCardNo(),user);

        return user.getaadharCardNo();
    }

}
