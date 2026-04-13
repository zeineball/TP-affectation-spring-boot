package tn.esprit.dto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.dto.DTOs.ProjetDetailsDTO;
import tn.esprit.dto.entities.ProjetDetail;
import tn.esprit.dto.repositories.ProjetDetailRepository;

import java.time.format.DateTimeFormatter;

@Service
public class ProjetDetailService {

    @Autowired
    ProjetDetailRepository projetDetailRepository;

    public ProjetDetailsDTO getDetailsProjet(Long id) {
        ProjetDetail detail = projetDetailRepository.findById(id).orElse(null);
        // Conversion Entité → DTO
        return convertToDto(detail);
    }

    private ProjetDetailsDTO convertToDto(ProjetDetail detail) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new ProjetDetailsDTO(
                detail.getDescription(),
                detail.getTechnologie(),
                detail.getDateDebut().format(formatter)
        );
    }
}
