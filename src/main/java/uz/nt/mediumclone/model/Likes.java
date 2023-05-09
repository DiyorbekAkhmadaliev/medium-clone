package uz.nt.mediumclone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Likes {

    @Id
    @GeneratedValue(generator = "like_id_seq")
    @SequenceGenerator(name = "like_id_seq", sequenceName = "like_id_seq", allocationSize = 1)
    private Integer id;
    private Integer article_id;
    private Integer user_id;

}
