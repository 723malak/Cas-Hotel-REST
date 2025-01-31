package ma.emsi.rest.dto;


public record ChambreRequestDTO(
        Long id,           // Chambre ID for updating
        String type,       // Chambre type
        Double prix,       // Chambre price
        Boolean disponible // Availability status of the chambre
) {}

