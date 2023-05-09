package uz.nt.mediumclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.mediumclone.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
