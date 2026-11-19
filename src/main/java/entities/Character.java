package entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private Integer height;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet planet;

    @ManyToMany
    @JoinTable(name = "character_films", joinColumns = {@JoinColumn(name = "id_character")}, inverseJoinColumns = {@JoinColumn(name = "id_film")})
    private Set<Film> films = new LinkedHashSet<>();

    public Character() {}

    public Character(Integer id, String name, Integer height, Planet planet) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.planet = planet;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

     public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}