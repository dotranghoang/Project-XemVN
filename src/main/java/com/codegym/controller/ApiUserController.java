package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.model.User;
import com.codegym.service.PostService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ApiUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/api/user")
    public ResponseEntity<List<User>> listAllUser(){
        List<User> users = (List<User>) userService.findAll();

        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User user = userService.findById(id);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/api/user/detail/{id}")
    public ResponseEntity<List<Post>> getAllPostOfUser(@PathVariable Long id){
        User user = userService.findById(id);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Post> posts = (List<Post>) postService.findAllByUser(user);

        return new ResponseEntity<>(posts,HttpStatus.OK);
    }



    @PostMapping("/api/user")
    public ResponseEntity<Void> createUser(@RequestBody User user){
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateType(@RequestBody User user,@PathVariable Long id){
         User user1 = userService.findById(id);

        if(user1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user1.setNickName(user.getNickName());
        user1.setAccount(user.getAccount());
        user1.setPassword(user.getPassword());
        userService.save(user1);

        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id){
        User user = userService.findById(id);

        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
