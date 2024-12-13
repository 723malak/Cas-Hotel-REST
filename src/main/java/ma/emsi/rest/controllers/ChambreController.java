package ma.emsi.rest.controllers;

import lombok.RequiredArgsConstructor;
import ma.emsi.rest.dto.ChambreRequestDTO;
import ma.emsi.rest.dto.ChambreResponseDTO;
import ma.emsi.rest.services.ChambreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chambres")
@RequiredArgsConstructor
public class ChambreController {

    private final ChambreService chambreService;

    @GetMapping
    public ResponseEntity<List<ChambreResponseDTO>> getAllChambres() {
        List<ChambreResponseDTO> chambres = chambreService.findAll();
        return new ResponseEntity<>(chambres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChambreResponseDTO> getChambreById(@PathVariable Long id) {
        Optional<ChambreResponseDTO> chambreResponseDTO = chambreService.findById(id);
        return chambreResponseDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<ChambreResponseDTO> createChambre(@RequestBody ChambreRequestDTO chambreRequestDTO) {
        Optional<ChambreResponseDTO> savedChambre = chambreService.save(chambreRequestDTO);
        return savedChambre.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChambreResponseDTO> updateChambre(@PathVariable Long id,
                                                            @RequestBody ChambreRequestDTO chambreRequestDTO) {
        Optional<ChambreResponseDTO> updatedChambre = chambreService.update(chambreRequestDTO, id);
        return updatedChambre.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ChambreResponseDTO> deleteChambre(@PathVariable Long id) {
        Optional<ChambreResponseDTO> deletedChambre = chambreService.delete(id);
        return deletedChambre.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/disponibilite/{isDisponible}")
    public ResponseEntity<List<ChambreResponseDTO>> getChambresByDisponibilite(@PathVariable boolean isDisponible) {
        List<ChambreResponseDTO> chambres = chambreService.findByDisponibilite(isDisponible);
        return new ResponseEntity<>(chambres, HttpStatus.OK);
    }
}
