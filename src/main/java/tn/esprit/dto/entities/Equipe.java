package tn.esprit.dto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

// Equipe.java
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @Enumerated(EnumType.STRING)
    private Domaine domaine;  // utiliser l'enum

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Projet> projets = new HashSet<>();  // ← initialiser obligatoire !
}
