package tn.esprit.dto.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.dto.DTOs.ProjetDTO;
import tn.esprit.dto.dtomapper.ProjetMapper;
import tn.esprit.dto.entities.Equipe;
import tn.esprit.dto.entities.Projet;
import tn.esprit.dto.entities.ProjetDetail;
import tn.esprit.dto.repositories.EquipeRepository;
import tn.esprit.dto.repositories.ProjetDetailRepository;
import tn.esprit.dto.repositories.ProjetRepository;


@Service
@AllArgsConstructor
public class ProjetService implements IProjetService {

    ProjetRepository projetRepository;
    ProjetDetailRepository projetDetailRepository;  // ← injecter les 3 repos !
    EquipeRepository equipeRepository;
    private ProjetMapper mapper;

    public ProjetDTO getProjet(Long id) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé avec id: " + id));
        return mapper.toDto(projet);
    }

    // Cas 1 : Ajouter Projet + ProjetDetail en même temps (cascade fait le travail)
    @Override
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }

    // Cas 2 : Affecter ProjetDetail existant à Projet existant
    @Override
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    // Cas 3 : Affecter Projet existant à Equipe existante
    @Override
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        equipe.getProjets().add(projet);  // ajouter dans la liste du parent
        equipeRepository.save(equipe);
    }

    // Cas 4 : Créer Projet + affecter un ProjetDetail déjà existant
    @Override
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    // Cas 5 : Désaffecter ProjetDetail d'un Projet
    @Override
    public Projet desaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }

    // Cas 6 : Désaffecter un Projet d'une Equipe
    @Override
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }
}

