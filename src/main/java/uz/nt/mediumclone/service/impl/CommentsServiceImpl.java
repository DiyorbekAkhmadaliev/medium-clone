package uz.nt.mediumclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.CommentsDto;
import uz.nt.mediumclone.model.Comments;
import uz.nt.mediumclone.repository.CommentsRepository;
import uz.nt.mediumclone.service.CommentsServices;
import uz.nt.mediumclone.service.mapper.CommentMapper;
import uz.nt.mediumclone.service.mapper.CommonMapper;

@Service
public class CommentsServiceImpl implements CommentsServices {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResponseEntity<?> addComment(CommentsDto commentsDto) {
        try {
            Comments saved = commentsRepository.save(commentMapper.toEntity(commentsDto));
            return ResponseEntity.ok().body(commentMapper.toDto(saved));
        }catch (Exception e){

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getCommentsByArticleId(Integer article_id) {
        return ResponseEntity.ok().body(commentsRepository.findAllByArticle_Id(article_id));
    }
}
