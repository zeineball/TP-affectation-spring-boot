package tn.esprit.dto.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProjetDetailsDTO {
    private String description;
    private String technologie;
    private String dateDebut; // Exemple: "19/07/2025" au lieu de LocalDate

    public ProjetDetailsDTO(String description, String technologie, String dateDebut) {
        this.description = description;
        this.technologie = technologie;
        this.dateDebut = dateDebut;
    }
}
