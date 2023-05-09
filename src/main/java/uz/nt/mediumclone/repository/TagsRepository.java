package uz.nt.mediumclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.mediumclone.model.Tag;

@Repository
public interface TagsRepository extends JpaRepository<Tag, Integer> {
}
