package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.entity.UserTes;
import org.acme.repository.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<UserTes> findAllUser() {
        return userRepository.findAll().list();
    }

    public void addUser(UserTes userTes) {
        userRepository.persist(userTes);
    }
}
