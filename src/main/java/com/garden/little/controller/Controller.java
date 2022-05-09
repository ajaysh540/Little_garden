package com.garden.little.controller;

import com.garden.little.modal.AdminUser;
import com.garden.little.modal.User;
import com.garden.little.modal.UserRequest;
import com.garden.little.repository.AdminUserRepository;
import com.garden.little.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  @Autowired UserRepository userRepository;
  @Autowired AdminUserRepository adminUserRepository;

  @PostMapping("/login")
  public User loginUser(@RequestBody UserRequest userRequest) {
    System.out.println("Getting user with username: " + userRequest.getEmail());
    return userRepository.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
  }

  @PostMapping("/admin/login")
  public AdminUser loginAdminUser(@RequestBody UserRequest userRequest) {
    System.out.println("Getting admin user with username: " + userRequest.getEmail());
    return adminUserRepository.findByEmailAndPassword(
        userRequest.getEmail(), userRequest.getPassword());
  }
}
