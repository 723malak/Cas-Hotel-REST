package ma.emsi.rest;

import lombok.RequiredArgsConstructor;
import ma.emsi.rest.dto.ChambreRequestDTO;
import ma.emsi.rest.dto.ClientRequestDTO;
import ma.emsi.rest.dto.ReservationRequestDTO;
import ma.emsi.rest.services.ChambreService;
import ma.emsi.rest.services.ClientService;
import ma.emsi.rest.services.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class RestMainApp {
    private final ClientService clientService;
    private final ChambreService chambreService;
    private final ReservationService reservationService;

    public static void main(String[] args) {
        SpringApplication.run(RestMainApp.class, args);
    }
    @Bean
    public CommandLineRunner run() {
        return args -> {
            // Insérer des clients exemples
            clientService.save(new ClientRequestDTO("Yassine Kabbaj", "yassine.kabbaj@example.ma", "0623456789"));
            clientService.save(new ClientRequestDTO("Mouna El Idrissi", "mouna.elidrissi@example.ma", "0687654321"));
            System.out.println("Clients exemples insérés avec succès.");

            // Insérer des chambres exemples
            chambreService.save(new ChambreRequestDTO(1L, "DOUBLE", 500.0, true));
            chambreService.save(new ChambreRequestDTO(2L, "SIMPLE", 120.0, true));
            System.out.println("Chambres exemples insérées avec succès.");

            // Insérer des réservations exemples
            reservationService.save(new ReservationRequestDTO(1L, 2L, "2024-12-15", "2024-12-20", "Séjour professionnel"));
            reservationService.save(new ReservationRequestDTO(2L, 1L, "2025-01-10", "2025-01-15", "Anniversaire surprise"));
            System.out.println("Réservations exemples insérées avec succès.");
        };
    }


}
