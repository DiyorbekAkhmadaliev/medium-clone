package uz.nt.mediumclone.service.impl;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsServices {

    private final CommentsRepository commentsRepository;
    private final CommentMapper commentMapper;

    @Override
    public ResponseEntity<String> addComment(CommentsDto commentsDto) {
        try {
            Comments saved = commentsRepository.save(commentMapper.toEntity(commentsDto));
            return ResponseEntity.ok().body("OK");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<CommentsDto> getCommentsByArticleId(Integer article_id) {
        return ResponseEntity.ok().body(commentMapper.toDto(commentsRepository.findAllByArticle_Id(article_id)));
    }
}
