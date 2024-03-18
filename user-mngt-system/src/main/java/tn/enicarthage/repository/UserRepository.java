package tn.enicarthage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
