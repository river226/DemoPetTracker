package xyz.jriver.PetTracker.Validator;

import org.springframework.stereotype.Service;
import xyz.jriver.PetTracker.Entity.Pet;
import xyz.jriver.PetTracker.Exceptions.InvalidPetException;

import static xyz.jriver.PetTracker.Entity.Enum.PetType.CAT;
import static xyz.jriver.PetTracker.Entity.Enum.PetType.DOG;

@Service
public class PetValidator {
    public Pet isValidPet(Pet pet) throws InvalidPetException {
        Pet result = null;
        if (pet == null || pet.getPetType() == null) {
            throw new InvalidPetException("Pet is null or pet type is null");
        }
        if (pet.getPetType() == DOG) {
            result = validateDog(pet);
        } else if (pet.getPetType() == CAT) {
            result = validateCat(pet);
        }

        if (result == null) {
            throw new InvalidPetException("Pet is not valid");
        }

        return result;
    }

    private Pet validateCat(Pet pet) {

        if (validatePet(pet) && pet.getLostTracker() != null) {
            return pet.buildCat();
        }
        return null;
    }

    private Pet validateDog(Pet pet) {
        if (validatePet(pet)) {
            return pet.buildDog();
        }
        return null;
    }

    private boolean validatePet(Pet pet) {
        return pet.getInZone() != null &&
                pet.getOwnerId() != null &&
                pet.getOwnerId() > 0 &&
                pet.getTrackerType() != null &&
                !pet.getTrackerType().isEmpty();
    }
}
