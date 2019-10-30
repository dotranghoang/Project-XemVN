package com.codegym.controller;

import com.codegym.model.Like;
import com.codegym.model.Post;
import com.codegym.model.User;
import com.codegym.service.LikeService;
import com.codegym.service.PostService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ApiLikeController {
    @Autowired
    private LikeService likeService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/like")
    public ResponseEntity<List<Like>> listAllComment() {
        List<Like> likes = (List<Like>) likeService.findAll();

        if (likes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @GetMapping("/api/like/{id}")
    public ResponseEntity<Like> getComment(@PathVariable Long id) {
        Like like = likeService.findById(id);

        if(like == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(like,HttpStatus.OK);
    }

    @PostMapping("/api/like")
    public ResponseEntity<Void> createComment(@RequestBody Like like){
        Post post = postService.findById(like.getPostId());
        User user = userService.findById(like.getUserId());
        if(post == null || user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        like.setPost(post);
        like.setUser(user);


        likeService.save(like);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}