import entities.Character;
import entities.Planet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.CharacterRepository;
import repository.PlanetRepository;

import java.util.List;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CharacterRepository characterRepository = new CharacterRepository(entityManager);
        PlanetRepository planetRepository = new PlanetRepository(entityManager);

        Planet earth = new Planet(1000, "Earth");
        Character jedi = new Character(1000, "Yoda", 100, earth);

        planetRepository.save(earth);
        characterRepository.save(jedi);

        Planet foundPlanet = planetRepository.findById(earth.getId());
        List<Planet> allPlanets = planetRepository.findAll();
        characterRepository.delete(jedi);
        characterRepository.update(jedi);

        entityManager.close();
        entityManagerFactory.close();

    }
}
