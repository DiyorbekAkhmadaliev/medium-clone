package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.nt.mediumclone.dto.ImageDto;

public interface ImageService {
    ResponseEntity<?> imageUpload(MultipartFile file);
    ResponseEntity<?> imageDowload(Integer id);


}
