package uz.nt.mediumclone.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.nt.mediumclone.dto.ImageDto;
import uz.nt.mediumclone.model.Image;
import uz.nt.mediumclone.repository.ImageRepository;
import uz.nt.mediumclone.service.ImageService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageSeriveImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public ResponseEntity<?> imageUpload(MultipartFile file){
        File files = new File(filePath("upload"));
        try {
            file.transferTo(files);
            Image imageEntity = new Image();
            imageEntity.setPath(files.getPath());
            imageRepository.save(imageEntity);
            return ResponseEntity.status(201).body(imageEntity.getId());
        } catch (IOException e) {
            return ResponseEntity.status(400).body("Not save");
        }


    }

    @Override
    public ResponseEntity<?> imageDowload(Integer id) {
        return null;
    }

//    public ResponseEntity imageDowload(Integer id){
//        Optional<Image> imageentity = imageRepository.findById(id);
//        String imagePath = imageentity.get().getPath();
//
//
//
//    }


    public String filePath(String folder){
        LocalDate localDate = LocalDate.now();
        String path = localDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        java.io.File file = new java.io.File(folder + "/"+ path);
        if (!file.exists()){
            file.mkdirs();
        }
        String uuid = UUID.randomUUID().toString();
        return file.getPath() + "\\"+ uuid;
    }

}
