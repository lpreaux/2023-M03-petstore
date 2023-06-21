package fr.diginamic.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product extends ABaseEntity {
    @Column(nullable = false, unique = true, length = 10)
    private String code;

    @Column(nullable = false, length = 64)
    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    private Double price;

    @ManyToMany
    @JoinTable(name = "products_petStores",
            joinColumns = @JoinColumn(name = "product_ID"),
            inverseJoinColumns = @JoinColumn(name = "petStores_ID"))
    private Set<PetStore> petStores = new LinkedHashSet<>();

    public void addPetStore(PetStore petStore) {
        petStore.getProducts().add(this);
        petStores.add(petStore);
    }

    public void removePetStore(PetStore petStore) {
        petStore.getProducts().remove(this);
        petStores.remove(petStore);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }
}