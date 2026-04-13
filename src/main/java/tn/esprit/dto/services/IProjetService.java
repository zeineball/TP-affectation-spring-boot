package tn.esprit.dto.services;

import tn.esprit.dto.entities.Projet;

public interface IProjetService {
    // Cas 1 : Ajouter Projet + ProjetDetail ensemble
    Projet addProjetAndProjetDetailAndAssign(Projet projet);

    // Cas 2 : Affecter un ProjetDetail existant à un Projet existant
    void assignProjetDetailToProjet(Long projetId, Long projetDetailId);

    // Cas 3 : Affecter un Projet existant à une Equipe existante
    void assignProjetToEquipe(Long projetId, Long equipeId);

    // Cas 4 : Créer un Projet et affecter un ProjetDetail existant
    Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);

    // Cas 5 : Désaffecter ProjetDetail d'un Projet
    Projet desaffecterProjetDetailFromProjet(Long projetId);

    // Cas 6 : Désaffecter un Projet d'une Equipe
    void desaffecterProjetFromEquipe(Long projetId, Long equipeId);
}
