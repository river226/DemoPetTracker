package xyz.jriver.PetTracker.Validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xyz.jriver.PetTracker.Entity.Enum.PetType;
import xyz.jriver.PetTracker.Entity.Pet;
import xyz.jriver.PetTracker.Exceptions.InvalidPetException;

import static org.junit.jupiter.api.Assertions.*;

class PetValidatorTest {

    static PetValidator petValidator;

    @BeforeAll
    public static void SetUp() {
        petValidator = new PetValidator();
    }

    @Test
    void isValidDog() throws InvalidPetException {
        Pet pet = petValidator.isValidPet(Pet.builder()
                .petType(PetType.DOG)
                .trackerType("test")
                .ownerId(226)
                .inZone(true)
                .build());

        assertNotNull(pet);
        assertEquals(PetType.DOG, pet.getPetType());
        assertEquals("test", pet.getTrackerType());
        assertEquals(226, pet.getOwnerId());
        assertEquals(true, pet.getInZone());
        assertNull(pet.getLostTracker());
    }

    @Test
    void isValidCat() throws InvalidPetException {
        Pet pet = petValidator.isValidPet(Pet.builder()
                .petType(PetType.CAT)
                .trackerType("test")
                .ownerId(226)
                .inZone(true)
                .lostTracker(true)
                .build());

        assertNotNull(pet);
        assertEquals(PetType.CAT, pet.getPetType());
        assertEquals("test", pet.getTrackerType());
        assertEquals(226, pet.getOwnerId());
        assertTrue(pet.getInZone());
        assertTrue(pet.getLostTracker());
    }

    @Test
    void isValidDog_2() throws InvalidPetException {
        Pet pet = petValidator.isValidPet(Pet.builder()
                .id(223)
                .petType(PetType.DOG)
                .trackerType("test 2")
                .ownerId(555)
                .inZone(false)
                .build());

        assertNotNull(pet);
        assertEquals(0, pet.getId());
        assertEquals(PetType.DOG, pet.getPetType());
        assertEquals("test 2", pet.getTrackerType());
        assertEquals(555, pet.getOwnerId());
        assertFalse(pet.getInZone());
        assertNull(pet.getLostTracker());
    }

    @Test
    void isValidCat_2() throws InvalidPetException {
        Pet pet = petValidator.isValidPet(Pet.builder()
                .id(223)
                .petType(PetType.CAT)
                .trackerType("test 2")
                .ownerId(555)
                .inZone(false)
                .lostTracker(false)
                .build());

        assertNotNull(pet);
        assertEquals(0, pet.getId());
        assertEquals(PetType.CAT, pet.getPetType());
        assertEquals("test 2", pet.getTrackerType());
        assertEquals(555, pet.getOwnerId());
        assertFalse(pet.getInZone());
        assertFalse(pet.getLostTracker());
    }

    @Test
    void isInvalidPet() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(null));

        assertEquals("Pet is null or pet type is null", exception.getMessage());
    }

    @Test
    void isInvalidPetType() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(Pet.builder()
                        .petType(null)
                        .trackerType("test")
                        .ownerId(226)
                        .inZone(true)
                        .build()));

        assertEquals("Pet is null or pet type is null", exception.getMessage());
    }

    @Test
    void isMissingInZone() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(Pet.builder()
                        .petType(PetType.CAT)
                        .trackerType("test 2")
                        .ownerId(555)
                        .lostTracker(false)
                        .build()));

        assertEquals("Pet is not valid", exception.getMessage());
    }

    @Test
    void isMissingOwnerId() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(Pet.builder()
                        .petType(PetType.DOG)
                        .trackerType("test 2")
                        .lostTracker(false)
                        .inZone(true)
                        .build()));

        assertEquals("Pet is not valid", exception.getMessage());
    }

    @Test
    void isMissingTrackerType() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(Pet.builder()
                        .petType(PetType.DOG)
                        .ownerId(555)
                        .inZone(true)
                        .build()));

        assertEquals("Pet is not valid", exception.getMessage());
    }

    @Test
    void isMissingLostTracker() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(Pet.builder()
                        .id(223)
                        .petType(PetType.CAT)
                        .trackerType("test 2")
                        .ownerId(555)
                        .inZone(false)
                        .build()));

        assertEquals("Pet is not valid", exception.getMessage());
    }


    @Test
    void hasInvalidOwnerId() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(Pet.builder()
                        .petType(PetType.DOG)
                        .trackerType("test 2")
                        .ownerId(-1)
                        .lostTracker(false)
                        .inZone(true)
                        .build()));

        assertEquals("Pet is not valid", exception.getMessage());
    }

    @Test
    void hasInvalidTrackerType() {
        Exception exception = assertThrows(InvalidPetException.class,
                () -> petValidator.isValidPet(Pet.builder()
                        .petType(PetType.DOG)
                        .ownerId(555)
                        .inZone(true)
                        .trackerType("")
                        .build()));

        assertEquals("Pet is not valid", exception.getMessage());
    }
}