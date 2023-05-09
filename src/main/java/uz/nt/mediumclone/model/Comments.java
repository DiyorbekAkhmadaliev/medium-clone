package uz.nt.mediumclone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    private Integer id;
    private String body;
    @ManyToOne(targetEntity = UserEntity.class)
    private UserEntity user;
}
