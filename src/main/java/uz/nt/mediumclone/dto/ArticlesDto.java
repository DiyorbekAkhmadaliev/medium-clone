package uz.nt.mediumclone.dto;

import lombok.*;
import uz.nt.mediumclone.model.Comments;
import uz.nt.mediumclone.model.Tag;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticlesDto {

    private Integer id;
    private String title;
    private String body;
    private String about;
    private Integer author_id;
    private List<Tag> tags;
    private List<UserDto> likes;
    private LocalDateTime publishDate;
    private LocalDateTime updatedAt;
}
