package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import com.springboot.hello.domain.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/user")
public class UserController {

    //    private final UserDao userDao;
    @Autowired
    private UserDao userDao;


    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("") // /user - user 등록하는 기능
    public ResponseEntity<Integer> add(@RequestBody UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getId(), userRequestDto.getName(),
                userRequestDto.getPassword());
        return ResponseEntity
                .ok()
                .body(userDao.add(user));
    }
    @DeleteMapping("/all") // /user/all - 전체 유저 지우는 기능
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }

    @DeleteMapping("/{id}") // /user/{id} - 특정 id 유저 지우는 기능
    public ResponseEntity<Integer> deleteById(@PathVariable("id") String id) {
        return ResponseEntity
                .ok()
                .body(userDao.deleteById(id));
    }

}
