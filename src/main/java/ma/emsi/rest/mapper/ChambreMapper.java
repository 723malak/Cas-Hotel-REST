package ma.emsi.rest.mapper;

import ma.emsi.rest.dto.ChambreRequestDTO;
import ma.emsi.rest.dto.ChambreResponseDTO;
import ma.emsi.rest.entities.Chambre;
import ma.emsi.rest.entities.TypeChambre;
import org.springframework.stereotype.Component;

@Component
public class ChambreMapper {

    public static ChambreResponseDTO toResponseDTO(Chambre chambre) {
        return ChambreResponseDTO.builder()
                .id(chambre.getId())
                .type(chambre.getType().toString())
                .prix(chambre.getPrix())
                .disponible(chambre.getDisponible())
                .build();
    }

    public static Chambre toEntity(ChambreRequestDTO dto) {
        return Chambre.builder()
                .id(dto.id())
                .type(TypeChambre.valueOf(dto.type()))
                .prix(dto.prix())
                .disponible(dto.disponible())
                .build();
    }
}

