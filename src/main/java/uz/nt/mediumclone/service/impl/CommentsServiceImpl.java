package uz.nt.mediumclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.nt.mediumclone.dto.CommentsDto;
import uz.nt.mediumclone.exeption.DatabaseException;
import uz.nt.mediumclone.model.Comments;
import uz.nt.mediumclone.repository.CommentsRepository;
import uz.nt.mediumclone.service.CommentsServices;
import uz.nt.mediumclone.service.mapper.CommentMapper;
import uz.nt.mediumclone.service.mapper.CommonMapper;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsServices {

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResponseEntity<CommentsDto> addComment(CommentsDto commentsDto) {
        try {
            return ResponseEntity
                    .ok()
                    .body(commentMapper.toDto(
                            commentsRepository.save(commentMapper.toEntity(commentsDto))));
        } catch (Exception e) {
            throw new DatabaseException("Error while add comment: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<CommentsDto>> getCommentsByArticleId(Integer article_id) {
        return ResponseEntity
                .ok()
                .body(commentsRepository.findAllByArticle_Id(article_id)
                        .stream()
                        .map(commentMapper::toDto)
                        .toList());
    }
}
