package com.user.management.service;

import com.user.management.model.User;

import com.user.management.repository.UserRepository;
import com.user.management.repository.UserSortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

//    @Autowired
//    private UserSortRepository userSortRepository;

//    UserService(UserRepository userRepository)
//    {
//        this.userRepository=userRepository;
//    }


    public User Add(User user) {

      //  List<User> userList = userRepository.findAll();
     //   List<User> optionalUsers = userList.stream().filter(e -> e.getEmail().equalsIgnoreCase(user.getEmail())).collect(Collectors.toList());
      //  if (optionalUsers.isEmpty()) {
    //        userRepository.save(user);
//        } else {
//            return null;
//        }
        return user;
    }

    public List<User> getAllUser() {
       // return userRepository.findAll();
        return null;
    }

    public Optional<User> getUserById(Long Id) {
      //  return userRepository.findById(Id);
        return null;
    }


    public Page<User> getAllUserBySort(Pageable pageable)
    {
      //  return userSortRepository.findAll(PageRequest.of(pageable.getPageNumber(),pageable.getPageSize()));
        return null;
    }


}
