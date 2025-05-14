package xyz.jriver.PetTracker.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.jriver.PetTracker.Entity.Pet;
import xyz.jriver.PetTracker.Entity.Response.InzoneDetail;
import xyz.jriver.PetTracker.Entity.Response.InzoneResponse;
import xyz.jriver.PetTracker.Exceptions.InvalidIdException;
import xyz.jriver.PetTracker.Repository.PetTrackerRepository;

import java.util.HashMap;
import java.util.List;

import static xyz.jriver.PetTracker.Entity.Enum.PetType.CAT;
import static xyz.jriver.PetTracker.Entity.Enum.PetType.DOG;

@AllArgsConstructor
@Service
public class PetTrackerService {

    PetTrackerRepository trackerRepository;

    public List<Pet> getAllPets() {
        return trackerRepository.findAll();
    }

    public Pet getPetById(int id) {
        Pet response = getAllPets().stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if(response == null) {
            throw new InvalidIdException("No pet found with id: " + id);
        }
        return response;
    }

    public int addPet(Pet pet) {
        return trackerRepository.save(pet).getId();
    }

    public InzoneResponse getPetsInZone() {
        List<Pet> pets = getAllPets();
        return new InzoneResponse(
                buildInzoneDetails(pets.stream()
                        .filter(pet -> pet.getPetType().equals(DOG))
                        .toList()),
                buildInzoneDetails(pets.stream()
                        .filter(pet -> pet.getPetType().equals(CAT))
                        .toList()));
    }

    private List<InzoneDetail> buildInzoneDetails(List<Pet> petsList) {
        HashMap<String, InzoneDetail> trackerTypeCount = new HashMap<>();
        for (Pet pet : petsList) {
            InzoneDetail trackerType = trackerTypeCount.getOrDefault(pet.getTrackerType(), new InzoneDetail(pet.getTrackerType(), 0, 0));
            if(pet.getInZone()) {
                trackerTypeCount.put(pet.getTrackerType(), new InzoneDetail(pet.getTrackerType(), trackerType.totalInZone() + 1, trackerType.totalOutZone()));
            } else {
                trackerTypeCount.put(pet.getTrackerType(), new InzoneDetail(pet.getTrackerType(), trackerType.totalInZone(), trackerType.totalOutZone() + 1));
            }
        }
       return trackerTypeCount.values().stream().toList();
    }
}
