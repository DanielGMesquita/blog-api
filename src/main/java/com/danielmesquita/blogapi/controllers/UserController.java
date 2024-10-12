package com.danielmesquita.blogapi.controllers;

import com.danielmesquita.blogapi.models.User;
import com.danielmesquita.blogapi.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
  @Autowired private UserService service;

  @PostMapping("/save")
  private @ResponseBody User save(@RequestBody User user) {
    return service.save(user);
  }

  @GetMapping(path = "/getAll")
  private @ResponseBody List<User> getAllUsers() {
    return service.getAll();
  }

  @GetMapping(path = "/get")
  private @ResponseBody Optional<User> getUser(@RequestParam final Long id) {
    return service.get(id);
  }

  @PutMapping(path = "/update")
  private @ResponseBody User updateUser(@RequestParam final Long id, @RequestBody User user) {
    return service.update(id, user);
  }

  @DeleteMapping(path = "/delete")
  private ResponseEntity<?> delete(@RequestParam final Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
