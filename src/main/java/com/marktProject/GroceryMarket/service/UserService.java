package com.marktProject.GroceryMarket.service;

import com.marktProject.GroceryMarket.model.User;
import com.marktProject.GroceryMarket.model.enums.EUserRoles;
import com.marktProject.GroceryMarket.repository.RolesRepository;
import com.marktProject.GroceryMarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewUser(User user) {

        user.setRoles(
                rolesRepository.getByRoleName(EUserRoles.USER.toString())
        );

        user = userRepository.save(user);

        return (user != null && user.getUserId() > 0);
    }
}
