package uz.nt.mediumclone.dto;

import lombok.*;

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
    private List<TagDto> tags;
    private LocalDateTime publishDate;
    private LocalDateTime updatedAt;
}
