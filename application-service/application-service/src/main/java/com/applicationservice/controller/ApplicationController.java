package com.applicationservice.controller;

import com.applicationservice.model.Application;
import com.applicationservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping(path = "/application-service/api")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @PostMapping(path = "/application")
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file, @RequestParam("jobSeekerId") int jobSeekerId,  @RequestParam("jobId") int jobId) throws Exception {
        String uploadFile = applicationService.uploadFile(file, jobSeekerId, jobId);
        return ResponseEntity.status(HttpStatus.OK).body(uploadFile);
    }
    @GetMapping(path = "/application/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws DataFormatException, IOException {
        byte[] downloadFile = applicationService.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.APPLICATION_PDF_VALUE)).body(downloadFile);
    }

}
