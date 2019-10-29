package com.codegym.controller;

import com.codegym.model.Post;
import com.codegym.model.Report;
import com.codegym.model.User;
import com.codegym.service.PostService;
import com.codegym.service.ReportService;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ApiReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/report")
    public ResponseEntity<List<Report>> listAllCommunity() {
        List<Report> reports = (List<Report>) reportService.findAll();

        if (reports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    @GetMapping("/api/report/{id}")
    public ResponseEntity<Report> getReport(@PathVariable Long id) {
        Report report = reportService.findById(id);

        if(report == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(report,HttpStatus.OK);
    }

    @PostMapping("/api/report")
    public ResponseEntity<Void> createReport(@RequestBody Report report){
        Post post = postService.findById(report.getPostId());
        User user = userService.findById(report.getUserId());
        if(post == null || user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        LocalDateTime dateTime = java.time.LocalDateTime.now();

        report.setPost(post);
        report.setUser(user);
        report.setDateTime(dateTime);

        reportService.save(report);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/api/report/{id}")
    public ResponseEntity<Void> editReport(@PathVariable Long id,@RequestBody Report report) {
        Report report1 = reportService.findById(id);
        LocalDateTime dateTime = java.time.LocalDateTime.now();
        Post post = postService.findById(report.getPostId());
        User user = userService.findById(report.getUserId());
        if(post == null || user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        report1.setPost(post);
        report1.setUser(user);
        report1.setDateTime(dateTime);
        report1.setReport(report.getReport());

        reportService.save(report1);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/api/report/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        Report report = reportService.findById(id);
        if (report == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        reportService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
