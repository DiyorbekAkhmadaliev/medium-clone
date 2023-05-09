package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import uz.nt.mediumclone.dto.TagDto;
import uz.nt.mediumclone.model.Tag;

import java.util.List;

public interface TagServices {

    ResponseEntity<?> addTags(List<Tag> tags);
    ResponseEntity<?> removeTags(List<Tag> tags);
}
