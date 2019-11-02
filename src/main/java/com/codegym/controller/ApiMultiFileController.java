package com.codegym.controller;

import com.codegym.model.FileForm;
import com.codegym.model.MultiFile;
import com.codegym.model.Post;
import com.codegym.service.MultiFileService;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ApiMultiFileController {
    @Autowired
    private MultiFileService multiFileService;

    @Autowired
    private PostService postService;

    @Autowired
    Environment env;

    @GetMapping("/api/file")
    public ResponseEntity<List<MultiFile>> GetAllFiles(){
        List<MultiFile> files = (List<MultiFile>) multiFileService.findAll();

        if(files.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(files,HttpStatus.OK);
    }

    @GetMapping("/api/file/{id}")
    public ResponseEntity<MultiFile> getFile(@PathVariable Long id){
        MultiFile file = multiFileService.findById(id);

        if(file == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(file,HttpStatus.OK);
    }

    @PostMapping(value = "/api/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<Void> uploadFile(@ModelAttribute FileForm fileForm, BindingResult result) {

        if(result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MultipartFile multipartFile = fileForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(fileForm.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MultiFile file = new MultiFile();
        Post post = postService.findById(file.getPostId());

        file.setNameFile(fileName);
        file.setPost(post);
        file.setPostId(fileForm.getPostId());

        multiFileService.save(file);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping(value = "/api/file/{3}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<Void> editFile(@ModelAttribute FileForm fileForm, @PathVariable Long id,BindingResult result){
        if(result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        MultipartFile multipartFile = fileForm.getFile();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();

        try {
            FileCopyUtils.copy(fileForm.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        MultiFile file = multiFileService.findById(id);
        Post post = postService.findById(file.getPostId());

        file.setNameFile(fileName);
        file.setPost(post);
        file.setPostId(fileForm.getPostId());

        multiFileService.save(file);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/file/{id}")
    public ResponseEntity<Void> deleteFile(@PathVariable Long id){
        MultiFile file = multiFileService.findById(id);
        if(file == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        multiFileService.remove(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
