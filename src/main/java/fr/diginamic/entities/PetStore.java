package fr.diginamic.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pet_store")
public class PetStore extends ABaseEntity {
    private String name;
    private String managerName;

    @ManyToMany(mappedBy = "petStores", cascade = CascadeType.PERSIST)
    private Set<Product> products = new LinkedHashSet<>();

    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "petStore", cascade = CascadeType.PERSIST)
    private Set<Animal> animals = new LinkedHashSet<>();

    public void addProduct(Product product) {
        product.addPetStore(this);
    }

    public void removerProduct(Product product) {
        product.removePetStore(this);
    }

    public void addAnimal(Animal animal) {
        animal.setPetStore(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}