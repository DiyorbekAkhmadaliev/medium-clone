package uz.nt.mediumclone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "user_id",strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    private String bio;
//
//    @OneToOne
//    private Image image;
}
