package gii.example.backend.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gii.example.backend.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByOrderByUserCreatedAtAscUserIdAsc();
    Optional<UserEntity> findByUserId(Long userId);
    Optional<UserEntity> findByUserEmail(String email);
}
