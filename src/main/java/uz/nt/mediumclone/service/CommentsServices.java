package uz.nt.mediumclone.service;

import org.springframework.http.ResponseEntity;
import uz.nt.mediumclone.dto.CommentsDto;

public interface CommentsServices {

    ResponseEntity<String> addComment(CommentsDto commentsDto);
    ResponseEntity<CommentsDto> getCommentsByArticleId(Integer article_id);
}
