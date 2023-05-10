package uz.nt.mediumclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.mediumclone.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    Comments findAllByArticle_Id(Integer id);
}
