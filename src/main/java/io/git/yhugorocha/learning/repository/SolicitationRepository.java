package io.git.yhugorocha.learning.repository;

import io.git.yhugorocha.learning.entities.SolicitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitationRepository extends JpaRepository<SolicitationEntity, Long> {
}
