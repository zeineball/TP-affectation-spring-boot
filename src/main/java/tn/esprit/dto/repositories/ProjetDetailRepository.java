package tn.esprit.dto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dto.entities.ProjetDetail;

@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail, Long> {
}
