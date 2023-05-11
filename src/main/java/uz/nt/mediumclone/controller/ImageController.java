package uz.nt.mediumclone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.nt.mediumclone.service.ImageService;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @PostMapping()
    public ResponseEntity<?> uploadImage(@RequestParam MultipartFile file){
        return imageService.imageUpload(file);
    }

    @GetMapping()
    public ResponseEntity dowloadImage(@PathVariable Integer id){
        return null;
//        return imageService.imageDowload(id);
    }
}
