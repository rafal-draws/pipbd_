package pipbd.bapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pipbd.bapp.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
