package ma.emsi.rest.repositories;

import ma.emsi.rest.entities.Chambre;
import ma.emsi.rest.entities.Client;
import ma.emsi.rest.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByChambre(Chambre chambre);
    List<Reservation> findByClient(Client chambre);

}
