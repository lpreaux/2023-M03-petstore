# Petstore JPA — formation Diginamic

> Dépôt pédagogique conservé comme support de cours. Il ne s'agit pas d'une application destinée à la production.

Exercice Java réalisé en 2023 pour modéliser une animalerie avec Jakarta Persistence, Hibernate et MariaDB.

## Notions travaillées

- entités et relations entre animalerie, animaux, adresses et produits ;
- héritage JPA avec `Animal`, `Cat` et `Fish` ;
- interfaces DAO et adaptateurs JPA ;
- transactions et configuration d'une unité de persistance.

## Exécution

Le projet utilise Java 17 et Maven. Configurez une base MariaDB locale, puis :

```bash
mvn compile
```

La classe `PetStoreApp` illustre la création et la lecture du jeu de données.
