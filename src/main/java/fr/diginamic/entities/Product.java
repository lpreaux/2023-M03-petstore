package fr.diginamic.entities;

import jakarta.persistence.*;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public ProdType getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}