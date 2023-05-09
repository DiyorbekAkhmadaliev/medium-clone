package uz.nt.mediumclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.nt.mediumclone.dto.TagDto;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(generator = "articleIdSeq")
    @SequenceGenerator(name = "article_id_seq", sequenceName = "article_id_seq", allocationSize = 1)
    private Integer id;
    private String title;
    private String body;
    private String about;
    private Integer author_id;
    @ManyToMany
    private List<Tag> tags;
    private LocalDateTime publishDate;
    private LocalDateTime updatedAt;
}
