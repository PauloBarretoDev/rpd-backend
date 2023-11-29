package com.rpdbackend.models;
import jakarta.persistence.*;
@Entity
public class BiologicalWeapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double weight;
    private double height;
    private boolean contained;
    @ManyToOne
    @JoinColumn(name = "bioWeaponType_id")
    private BioWeaponType bioWeaponType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isContained() {
        return contained;
    }

    public void setContained(boolean contained) {
        this.contained = contained;
    }
}
