package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.model.Post;
import com.codegym.model.User;
import com.codegym.service.CommentService;
import com.codegym.service.PostService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ApiCommentController {


    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/comment")
    public ResponseEntity<List<Comment>> listAllComment() {
        List<Comment> commentList = (List<Comment>) commentService.findAll();

        if (commentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @GetMapping("/api/comment/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        Comment comment = commentService.findById(id);

        if(comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(comment,HttpStatus.OK);
    }

    @PostMapping("/api/comment")
    public ResponseEntity<Void> createComment(@RequestBody Comment comment){
        Post post = postService.findById(comment.getPostId());
        User user = userService.findById(comment.getUserId());
        LocalDateTime dateTime = java.time.LocalDateTime.now();
        if(post == null || user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        comment.setPost(post);
        comment.setUser(user);
        comment.setDateTime(dateTime);

        commentService.save(comment);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/api/comment/{id}")
    public ResponseEntity<Void> editComment(@PathVariable Long id,@RequestBody Comment comment) {
        Comment comment1 = commentService.findById(id);
        LocalDateTime dateTime = java.time.LocalDateTime.now();
        Post post = postService.findById(comment.getPostId());
        User user = userService.findById(comment.getUserId());
        if(post == null || user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        comment1.setPost(post);
        comment1.setUser(user);
        comment1.setDateTime(dateTime);
        comment1.setComment(comment.getComment());

        commentService.save(comment1);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        if (comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        commentService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

