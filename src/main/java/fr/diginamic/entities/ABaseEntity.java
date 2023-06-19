package fr.diginamic.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class ABaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Transient
    private boolean isNew = true;

    public ABaseEntity() {
    }

    public ABaseEntity(long id) {
        this.id = id;
    }

    @PrePersist
    @PostLoad
    public void trackNotNew() {
        this.isNew = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isNew() {
        return isNew;
    }

    @Override
    public String toString() {
        return "ABaseEntity{" +
                "id=" + id +
                '}';
    }
}
