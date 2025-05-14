package xyz.jriver.PetTracker.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.jriver.PetTracker.Entity.Pet;
import xyz.jriver.PetTracker.Entity.Response.InzoneResponse;
import xyz.jriver.PetTracker.Exceptions.InvalidPetException;
import xyz.jriver.PetTracker.Service.PetTrackerService;
import xyz.jriver.PetTracker.Validator.PetValidator;

import java.util.List;

@RestController(value = "pet")
@AllArgsConstructor
public class PetTrackerController {

    PetTrackerService petTrackerService;
    PetValidator petValidator;

    @PostMapping()
    public int  postPet(@RequestBody Pet pet) throws InvalidPetException {
        Pet petToSave = petValidator.isValidPet(pet);
        return petTrackerService.addPet(petToSave);
    }

    @GetMapping("/all")
    public List<Pet> getAllPets() {
        return petTrackerService.getAllPets();
    }

    @GetMapping("/id/{id}")
    public Pet getPetById(@PathVariable String id) {
        return petTrackerService.getPetById(Integer.parseInt(id));
    }

    @GetMapping("/inzone")
    public InzoneResponse getPetsInZone() {
        return petTrackerService.getPetsInZone();
    }

}
