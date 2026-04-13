package tn.esprit.dto.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ProjetDTO {
    private String libelleProjet;

    public String getLibelleProjet() { return libelleProjet; }
    public void setLibelleProjet(String libelleProjet) { this.libelleProjet = libelleProjet; }
}
