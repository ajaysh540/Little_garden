package com.garden.little.controller;

import com.garden.little.modal.AdminUser;
import com.garden.little.modal.User;
import com.garden.little.modal.UserRequest;
import com.garden.little.repository.AdminUserRepository;
import com.garden.little.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
  @Autowired UserRepository userRepository;
  @Autowired AdminUserRepository adminUserRepository;

  @PostMapping("/login")
  public User loginUser(@RequestBody UserRequest userRequest) {
    System.out.println("Getting user with username: " + userRequest.getEmail());
    User user =
        userRepository.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
    user.setPassword("************");
    return user;
  }

  @PostMapping("/admin/login")
  public AdminUser loginAdminUser(@RequestBody UserRequest userRequest) {
    System.out.println("Getting admin user with username: " + userRequest.getEmail());
    AdminUser adminUser =
        adminUserRepository.findByEmailAndPassword(
            userRequest.getEmail(), userRequest.getPassword());
    adminUser.setPassword("************");
    return adminUser;
  }

  @PostMapping("admin/signup")
  public AdminUser signUpAdmin(@RequestBody AdminUser adminUser) {
    System.out.println("Creating new Admin");
    adminUser = adminUserRepository.save(adminUser);
    adminUser.setPassword("************");
    return adminUser;
  }

  @PostMapping("user/signup")
  public User signUpUser(@RequestBody User user) {
    System.out.println("Creating new User");
    user = userRepository.save(user);
    user.setPassword("************");
    return user;
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    System.out.println("Getting all users");
    return userRepository.findAll().stream()
        .map(
            user -> {
              user.setPassword("************");
              return user;
            })
        .collect(Collectors.toList());
  }

  @PutMapping("/update")
  public User updateUser(@RequestBody User user) {
    System.out.println(user);
    User actualUser = userRepository.findByUserId(user.getUserId());
    System.out.println(actualUser);
    user.setPassword(actualUser.getPassword());
    System.out.println("Updating user: " + user.getEmail());
    user = userRepository.save(user);
    user.setPassword("************");
    return user;
  }
}
