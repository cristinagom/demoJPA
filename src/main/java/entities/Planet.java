package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "rotation_period")
    private Integer rotationPeriod;

    @Column(name = "orbital_period")
    private Integer orbitalPeriod;

    @Column(name = "diameter")
    private Integer diameter;

    @Lob
    @Column(name = "climate")
    private String climate;

    @Lob
    @Column(name = "gravity")
    private String gravity;

    @Lob
    @Column(name = "terrain")
    private String terrain;

    @Lob
    @Column(name = "surface_water")
    private String surfaceWater;

    @Column(name = "population")
    private Long population;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_date")
    private Instant createdDate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_date")
    private Instant updatedDate;

    @Lob
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "planet")
    private Set<Character> characters = new LinkedHashSet<>();

    public Planet() {}

    public Planet(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Integer rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public Integer getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Integer orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

}