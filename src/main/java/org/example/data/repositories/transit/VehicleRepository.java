package org.example.data.repositories.transit;

import org.example.data.model.transit.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles, Long> {
}
