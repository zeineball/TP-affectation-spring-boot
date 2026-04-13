    package tn.esprit.dto.dtomapper;

    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;
    import tn.esprit.dto.DTOs.ProjetDTO;
    import tn.esprit.dto.DTOs.ProjetDetailsDTO;
    import tn.esprit.dto.entities.Projet;

    import java.util.List;

    @Mapper(componentModel = "spring")
    public interface ProjetMapper {

        @Mapping(target = "libelleProjet", source = "sujet")  // ← "nom" → "sujet"
        ProjetDTO toDto(Projet projet);

        @Mapping(source = "sujet", target = "description")    // ← "nom" → "sujet"
        @Mapping(source = "projetDetail.technologie", target = "technologie")
        @Mapping(source = "projetDetail.dateDebut", target = "dateDebut",
                dateFormat = "dd/MM/yyyy")
        ProjetDetailsDTO toProjetDetailsDTO(Projet projet);

        List<ProjetDetailsDTO> toProjetDetailsDTOs(List<Projet> projets);
    }
