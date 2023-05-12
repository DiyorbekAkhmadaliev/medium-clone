package uz.nt.mediumclone.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.nt.mediumclone.model.Tag;

import java.util.List;

@Repository
public interface TagsRepository extends CrudRepository<Tag, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tag(name) VALUES (?1) ON CONFLICT DO NOTHING", nativeQuery = true)
    void saveNewTags(String tagName);

//    @Modifying
//    @Query(value = "INSERT INTO tag(name) VALUES (:tagNames) ON CONFLICT DO NOTHING", nativeQuery = true)
//    void saveNewTags(@Param("tagNames") List<String> tagNames);
}
