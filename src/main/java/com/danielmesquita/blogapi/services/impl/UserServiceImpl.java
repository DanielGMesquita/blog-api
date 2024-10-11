package com.danielmesquita.blogapi.services.impl;

import com.danielmesquita.blogapi.exceptions.ResourceNotFoundException;
import com.danielmesquita.blogapi.models.User;
import com.danielmesquita.blogapi.repositories.UserRepository;
import com.danielmesquita.blogapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("User already exists");
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User update(Long id, User newUserData) {
        User userToEdit = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userToEdit.setName(newUserData.getName());
        userToEdit.setEmail(newUserData.getEmail());

        return userRepository.save(userToEdit);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
