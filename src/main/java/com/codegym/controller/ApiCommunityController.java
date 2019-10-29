package com.codegym.controller;

import com.codegym.model.Community;
import com.codegym.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiCommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/api/community")
    public ResponseEntity<List<Community>> listAllCommunity() {
        List<Community> communities = (List<Community>) communityService.findAll();

        if (communities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(communities, HttpStatus.OK);
    }
}
