package uz.nt.mediumclone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follows {

    @Id
    @GeneratedValue(generator = "followsIdSeq")
    @SequenceGenerator(name = "follows_id_seq", sequenceName = "follows_id_seq", allocationSize = 1)
    private Integer id;
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity following;
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity followed;
}
