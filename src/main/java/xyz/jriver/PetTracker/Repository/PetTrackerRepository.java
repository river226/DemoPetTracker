package xyz.jriver.PetTracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.jriver.PetTracker.Entity.Pet;

@Repository
public interface PetTrackerRepository extends JpaRepository<Pet, Integer> {
    // Blank
}
