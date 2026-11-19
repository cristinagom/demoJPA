package entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "episode", length = 12)
    private String episode;

    @Column(name = "title", length = 30)
    private String title;

    @ManyToMany(mappedBy = "films")
    private Set<Character> characters = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

}