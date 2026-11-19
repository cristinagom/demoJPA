package repository;

import entities.Planet;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PlanetRepository implements Repository<Planet> {
    private final EntityManager entityManager;

    public PlanetRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Planet findById(int id) {
        return entityManager.find(Planet.class, id);
    }

    @Override
    public List<Planet> findAll() {
        return entityManager.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
    }

    @Override
    public void save(Planet planet) {
        entityManager.getTransaction().begin();
        entityManager.persist(planet);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Planet planet) {
        entityManager.getTransaction().begin();
        entityManager.remove(planet);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Planet planet) {
        entityManager.getTransaction().begin();
        entityManager.merge(planet);
        entityManager.getTransaction().commit();
    }


}
