package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    ResponseEntity<?> imageUpload(MultipartFile file);
    byte[] imageDowload(Integer id) throws IOException;


}
