package tn.esprit.dto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// ProjetDetail.java
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String technologie;
    private Long cout;
    private LocalDate dateDebut;

    @OneToOne(mappedBy = "projetDetail")  // fils, mappedBy pointe vers le champ du parent
    @ToString.Exclude
    @JsonIgnore
    private Projet projet;
}
