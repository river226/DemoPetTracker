package xyz.jriver.PetTracker.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import xyz.jriver.PetTracker.Entity.Enum.PetType;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        int id;
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        PetType petType;
        String trackerType;
        Integer ownerId;
        Boolean inZone;
        Boolean lostTracker;

        public Pet buildCat() {
            return Pet.builder()
                    .petType(PetType.CAT)
                    .trackerType(trackerType)
                    .ownerId(ownerId)
                    .inZone(inZone)
                    .lostTracker(lostTracker)
                    .build();
        }

        public Pet buildDog() {
                return Pet.builder()
                        .petType(PetType.DOG)
                        .trackerType(trackerType)
                        .ownerId(ownerId)
                        .inZone(inZone)
                        .lostTracker(null)
                        .build();
        }
}
