package com.rpdbackend.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BioWeaponType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String weakness;
    @OneToMany(mappedBy = "bioWeaponType")
    private List<BiologicalWeapon> biologicalWeapons;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
}
