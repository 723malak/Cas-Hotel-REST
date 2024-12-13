package ma.emsi.rest.dto;

;


public record ReservationRequestDTO(
        Long clientId,
        Long chambreId,
        String dateDebut,
        String dateFin,
        String preferences
) {}
