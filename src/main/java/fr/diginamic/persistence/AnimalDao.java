package fr.diginamic.persistence;

import fr.diginamic.entities.Animal;

public interface AnimalDao<T extends Animal> extends Dao<T> {
}
