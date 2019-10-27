package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiPostController {
    @Autowired
    private PostService postService;

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


}
