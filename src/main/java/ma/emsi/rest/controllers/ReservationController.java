package ma.emsi.rest.controllers;

import lombok.RequiredArgsConstructor;
import ma.emsi.rest.dto.ReservationRequestDTO;
import ma.emsi.rest.dto.ReservationResponseDTO;
import ma.emsi.rest.services.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;


    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations() {
        List<ReservationResponseDTO> reservations = reservationService.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable Long id) {
        Optional<ReservationResponseDTO> reservationResponseDTO = reservationService.findById(id);
        return reservationResponseDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }


    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        Optional<ReservationResponseDTO> savedReservation = reservationService.save(reservationRequestDTO);
        return savedReservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> updateReservation(@PathVariable Long id,
                                                                    @RequestBody ReservationRequestDTO reservationRequestDTO) {
        Optional<ReservationResponseDTO> updatedReservation = reservationService.update(reservationRequestDTO, id);
        return updatedReservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> deleteReservation(@PathVariable Long id) {
        Optional<ReservationResponseDTO> deletedReservation = reservationService.delete(id);
        return deletedReservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }
}
