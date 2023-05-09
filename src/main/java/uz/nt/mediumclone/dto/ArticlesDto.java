package uz.nt.mediumclone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
