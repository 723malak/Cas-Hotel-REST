package ma.emsi.rest.mapper;

import ma.emsi.rest.dto.ReservationResponseDTO;
import ma.emsi.rest.entities.Reservation;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
@Component
public class ReservationMapper {

        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static ReservationResponseDTO toResponseDTO(Reservation reservation) {
        return ReservationResponseDTO.builder()
                .id(reservation.getId())
                .client(ClientMapper.toResponseDTO(reservation.getClient()))
                .chambre(ChambreMapper.toResponseDTO(reservation.getChambre()))
                .dateDebut(DATE_FORMATTER.format(reservation.getDatedebut()))
                .dateFin(DATE_FORMATTER.format(reservation.getDatefin()))
                .preferences(reservation.getPreferences())
                .build();
    }


}
