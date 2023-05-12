package uz.nt.mediumclone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.nt.mediumclone.model.Tag;

@Repository
public interface TagsRepository extends CrudRepository<Tag, Integer> {
}
