package com.applicationservice.service;

import com.applicationservice.model.Application;
import com.applicationservice.repository.ApplicationRepository;
import com.applicationservice.util.ApplicationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

import static com.applicationservice.util.ApplicationUtils.decompressFile;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    public String uploadFile(MultipartFile file,  int jobSeekerId, int jobId) throws Exception {
        Application application = applicationRepository.save(Application.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(ApplicationUtils.compressFile(file.getBytes()))
                .jobSeekerId(jobSeekerId)
                .jobId(jobId)
                .build());

        if(application != null){
            return "File upload successfully"+file.getOriginalFilename();
        }
        return null;
    }

    //Download File
    public byte[] downloadFile(String fileName) throws IOException, DataFormatException {
        Optional<Application> applicationOptional = applicationRepository.findByName(fileName);
        if (applicationOptional.isPresent()) {
            Application application = applicationOptional.get();
            return decompressFile(application.getFileData());
        } else {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
    }

}