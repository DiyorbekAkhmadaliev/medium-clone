package uz.nt.mediumclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(generator = "article_id_seq")
    @SequenceGenerator(name = "article_id_seq", sequenceName = "article_id_seq", allocationSize = 1)
    private Integer id;
    private String title;
    private String body;
    private String about;
    private Integer author_id;
    @ManyToMany(targetEntity = Tag.class, cascade = CascadeType.ALL)
    private List<Tag> tags;
    private LocalDateTime publishDate;
    private LocalDateTime updatedAt;
    @OneToMany(targetEntity = Comments.class)
    private List<Comments> comments;
}
