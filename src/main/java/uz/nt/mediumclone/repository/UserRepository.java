package uz.nt.mediumclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.mediumclone.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
