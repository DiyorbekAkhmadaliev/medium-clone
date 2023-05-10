package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import uz.nt.mediumclone.dto.CommentsDto;

public interface CommentsServices {

    ResponseEntity<?> addComment(CommentsDto commentsDto);
    ResponseEntity<?> getCommentsByArticleId(Integer article_id);
}
