package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.entity.HighscoreEntity;

import java.util.UUID;

@Repository
public interface HighscoreRepository extends JpaRepository<HighscoreEntity, UUID> {
}
