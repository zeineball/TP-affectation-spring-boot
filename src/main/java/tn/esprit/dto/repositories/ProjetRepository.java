package tn.esprit.dto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.dto.DTOs.ProjetDTO;
import tn.esprit.dto.DTOs.ProjetDetailsDTO;
import tn.esprit.dto.entities.Projet;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    // ← "p.nom" remplacé par "p.sujet"
    @Query("SELECT new tn.esprit.dto.DTOs.ProjetDTO(p.sujet) FROM Projet p")
    List<ProjetDTO> getAllProjetDTOs();

    @Query("""
        SELECT p
        FROM Projet p
        JOIN FETCH p.projetDetail d
    """)
    List<Projet> getProjetsAvecDetails();
}
