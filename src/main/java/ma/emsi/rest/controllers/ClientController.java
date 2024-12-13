package ma.emsi.rest.controllers;

import lombok.RequiredArgsConstructor;
import ma.emsi.rest.dto.ClientRequestDTO;
import ma.emsi.rest.dto.ClientResponseDTO;
import ma.emsi.rest.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> clients = clientService.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        Optional<ClientResponseDTO> clientResponseDTO = clientService.findById(id);
        return clientResponseDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<ClientResponseDTO>> searchClients(@PathVariable String keyword) {
        List<ClientResponseDTO> clients = clientService.findByEmailOrName(keyword);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        Optional<ClientResponseDTO> savedClient = clientService.save(clientRequestDTO);
        return savedClient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id,
                                                          @RequestBody ClientRequestDTO clientRequestDTO) {
        Optional<ClientResponseDTO> updatedClient = clientService.update(clientRequestDTO, id);
        return updatedClient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> deleteClient(@PathVariable Long id) {
        Optional<ClientResponseDTO> deletedClient = clientService.delete(id);
        return deletedClient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
