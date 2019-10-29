package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.model.Type;
import com.codegym.model.User;
import com.codegym.service.PostService;
import com.codegym.service.TypeService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ApiPostController {
    @Autowired
    private PostService postService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private UserService userService;
    @GetMapping("/api/post")
    public ResponseEntity<List<Post>> listAllPost(){
        List<Post> posts = (List<Post>) postService.findAll();

        if(posts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/api/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @PostMapping("/api/post")
    public ResponseEntity<Void> createPost(@RequestBody Post post){
       Type type = typeService.findById(post.getTypeId());
       User user = userService.findById(post.getUserId());

        LocalDateTime date = java.time.LocalDateTime.now() ;
        post.setDate(date);
        post.setType(type);
        post.setUser(user);

        postService.save(post);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/post/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post,@PathVariable Long id){
        Post post1 = postService.findById(id);
        LocalDateTime date = java.time.LocalDateTime.now() ;
        if(post1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(post.getTypeId() != null) {
            Type type = typeService.findById(post.getTypeId());
            post1.setType(type);
        } else {
            post1.setType(post.getType());
        }

        if(post.getUserId() != null) {
            User user = userService.findById(post.getUserId());
            post1.setUser(user);
        } else {
            post1.setUser(post.getUser());
        }
        post1.setTypeId(post.getTypeId());
        post1.setUserId(post.getUserId());
        post1.setTitle(post.getTitle());
        post1.setVideo(post.getVideo());
        post1.setImage(post.getImage());
        post1.setDate(date);

        postService.save(post1);

        return new ResponseEntity<>(post1,HttpStatus.OK);

    }

    @DeleteMapping("/api/post/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        Post post = postService.findById(id);

        if(post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
