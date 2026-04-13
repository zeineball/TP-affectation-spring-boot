package tn.esprit.dto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dto.entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
