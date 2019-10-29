package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.model.Type;
import com.codegym.service.PostService;
import com.codegym.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ApiTypeController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private PostService postService;

    @GetMapping("/api/type")
    public ResponseEntity<List<Type>> listAllType(){
        List<Type> types = (List<Type>) typeService.findAll();

        if(types.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(types,HttpStatus.OK);
    }

    @GetMapping("/api/type/detail/{id}")
    public ResponseEntity<List<Post>> getAllPostOfType(@PathVariable Long id) {
        Type type = typeService.findById(id);

        if(type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

         List<Post> posts = (List<Post>) postService.findAllByType(type);

        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/api/type/{id}")
    public ResponseEntity<Type> getType(@PathVariable Long id) {
        Type type = typeService.findById(id);

        if(type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(type,HttpStatus.OK);

    }

    @PostMapping("/api/type")
    public ResponseEntity<Void> createType(@RequestBody Type type){
        typeService.save(type);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/api/type/{id}")
    public ResponseEntity<Type> updateType(@RequestBody Type type,@PathVariable Long id){
        Type type1 = typeService.findById(id);

        if(type1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        type1.setType(type.getType());
        typeService.save(type1);

        return new ResponseEntity<>(type1,HttpStatus.OK);
    }

    @DeleteMapping("/api/type/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id){
        Type type = typeService.findById(id);

        if(type == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        typeService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
