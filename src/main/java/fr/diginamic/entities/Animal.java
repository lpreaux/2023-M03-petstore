package fr.diginamic.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal extends ABaseEntity {
    private LocalDate birth;
    private String color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_store_id", nullable = false)
    private PetStore petStore;

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        if (null != this.petStore) {
            this.petStore.getAnimals().remove(this);
        }
        this.petStore = petStore;
        this.petStore.getAnimals().add(this);
    }
}