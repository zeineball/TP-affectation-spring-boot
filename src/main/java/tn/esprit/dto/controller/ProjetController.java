package tn.esprit.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dto.DTOs.ProjetDTO;
import tn.esprit.dto.DTOs.ProjetDetailsDTO;
import tn.esprit.dto.entities.Projet;
import tn.esprit.dto.services.IProjetService;
import tn.esprit.dto.services.ProjetDetailService;
import tn.esprit.dto.services.ProjetService;


@RestController
@RequestMapping("/api/projet")  // ← doit correspondre exactement à l'URL
public class ProjetController {

    @Autowired
    private ProjetDetailService projetDetailService;

    @Autowired
    private ProjetService projetService;

    @GetMapping("/{id}/details")
    public ProjetDetailsDTO getDetails(@PathVariable Long id) {
        return projetDetailService.getDetailsProjet(id);
    }

    @GetMapping("/{id}")
    public ProjetDTO getProjet(@PathVariable Long id) {
        return projetService.getProjet(id);
    }


    // Cas 1 : POST http://localhost:8081/tp8/projet/ajouter-projet-et-projet-detail
    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet p) {
        return projetService.addProjetAndProjetDetailAndAssign(p);
    }

    // Cas 2 : PUT http://localhost:8081/tp8/projet/affecter-projet-a-projet-details/1/1
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecterProjetAProjetDetail(
            @PathVariable("projet-id") Long projetId,
            @PathVariable("projet-details-id") Long projetDetailsId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailsId);
    }

    // Cas 3 : PUT http://localhost:8081/tp8/projet/affecter-projet-equipe/1/1
    @PutMapping("/affecter-projet-equipe/{projet-id}/{equipe-id}")
    public void affecterProjetEquipe(
            @PathVariable("projet-id") Long projetId,
            @PathVariable("equipe-id") Long equipeId) {
        projetService.assignProjetToEquipe(projetId, equipeId);
    }

    // Cas 4 : POST http://localhost:8081/tp8/projet/creer-projet-et-affecter-projet-detail-a-projet/1
    @PostMapping("/creer-projet-et-affecter-projet-detail-a-projet/{projetDetailId}")
    public Projet creerProjetEtAffecterDetail(
            @RequestBody Projet projet,
            @PathVariable Long projetDetailId) {
        return projetService.addProjetAndAssignProjetToProjetDetail(projet, projetDetailId);
    }

    // Cas 5 : PUT http://localhost:8081/tp8/projet/desaffecter-projet-detail/1
    @PutMapping("/desaffecter-projet-detail/{projetId}")
    public Projet desaffecterProjetDetail(@PathVariable Long projetId) {
        return projetService.desaffecterProjetDetailFromProjet(projetId);
    }

    // Cas 6 : PUT http://localhost:8081/tp8/projet/desaffecter-projet-de-equipe/1/1
    @PutMapping("/desaffecter-projet-de-equipe/{projet-id}/{equipe-id}")
    public void desaffecterProjetDeEquipe(
            @PathVariable("projet-id") Long projetId,
            @PathVariable("equipe-id") Long equipeId) {
        projetService.desaffecterProjetFromEquipe(projetId, equipeId);
    }
}
