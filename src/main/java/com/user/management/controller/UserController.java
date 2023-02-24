package com.user.management.controller;


import com.user.management.model.User;

import com.user.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/add-user")
    ResponseEntity<?> AddUser(@RequestBody User user) {
        User savedUser = userService.Add(user);
        if(savedUser==null)
        {
            return new ResponseEntity("already exist", HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity(savedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-user-by-id/{id}",method = RequestMethod.GET)
    ResponseEntity<?> GetUserById(@PathVariable("id") Long Id) {
        Optional<User> user = userService.getUserById(Id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-users", method = RequestMethod.GET)
    ResponseEntity<?> GetAllUser() {
        List<User> savedUserList = userService.getAllUser();
        return new ResponseEntity<>(savedUserList, HttpStatus.OK);
    }

    ResponseEntity<?> UpdateUser() {
        return null;
    }

    ResponseEntity<?> DeleteUser() {
        return null;
    }


    @RequestMapping(value = "/get-users-by-page")
    ResponseEntity<?> getUserbyPage(Pageable pageable)
    {

       Page page=userService.getAllUserBySort(pageable);
return ResponseEntity.ok(page.toList());


    }


}
