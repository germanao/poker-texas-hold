package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.entity.UserTes;
import org.acme.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Path("/api/user")
public class UserController {

    @Inject
    UserService userService;

    @GET
    public List<UserTes> retrieveUsers() {

        List<UserTes> userTes = new ArrayList<>();
        try {
            userTes = userService.findAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userTes;
    }
    @POST
    @Transactional
    public void addUser(UserTes userTes){
        userService.addUser(userTes);
    }
}
