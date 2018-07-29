package rocks.raccoon.terrarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rocks.raccoon.terrarium.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
