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
public class Tag {

    @Id
    @GeneratedValue(generator = "tagIdSeq")
    @SequenceGenerator(name = "tag_id_seq", sequenceName = "tag_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private Integer num_of_usage;
}
