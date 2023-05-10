package uz.nt.mediumclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.nt.mediumclone.dto.CommentsDto;
import uz.nt.mediumclone.service.CommentsServices;

@RestController
@RequestMapping("comment")
public class CommentsResources {

    @Autowired
    private CommentsServices commentsServices;

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody CommentsDto commentsDto){
        return commentsServices.addComment(commentsDto);
    }

    @GetMapping("by-id/{id}")
    public ResponseEntity<?> getCommentByArticleId(@PathVariable Integer id){
        return commentsServices.getCommentsByArticleId(id);
    }
}
