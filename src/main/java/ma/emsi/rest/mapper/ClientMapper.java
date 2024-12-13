package ma.emsi.rest.mapper;

import ma.emsi.rest.dto.ClientRequestDTO;
import ma.emsi.rest.dto.ClientResponseDTO;
import ma.emsi.rest.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public static ClientResponseDTO toResponseDTO(Client client) {
        return ClientResponseDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .tel(client.getTel())
                .build();
    }

    public static Client toEntity(ClientRequestDTO dto) {
        return Client.builder()
                .nom(dto.nom())
                .email(dto.email())
                .tel(dto.tel())
                .build();
    }
}
