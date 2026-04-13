package tn.esprit.dto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


// Projet.java
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet; // renommer 'nom' en 'sujet' comme dans le diagramme

    @OneToOne(cascade = CascadeType.ALL)  // Parent → cascade vers fils
    private ProjetDetail projetDetail;

    @ManyToMany(mappedBy = "projets")
    @JsonIgnore
    private Set<Equipe> equipes = new HashSet<>();
}
