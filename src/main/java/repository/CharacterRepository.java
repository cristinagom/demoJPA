package repository;

import entities.Character;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CharacterRepository implements Repository<Character>{

    private final EntityManager entityManager;

    public CharacterRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Character findById(int id) {
        return entityManager.find(Character.class, id);
    }
    public List<Character> findAll() {
        return entityManager.createQuery("SELECT c FROM Character c JOIN FETCH c.planet", Character.class)
                .getResultList();
    }

    @Override
    public void save(Character character) {
        entityManager.getTransaction().begin();
        entityManager.persist(character);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Character character) {
        entityManager.getTransaction().begin();
        entityManager.remove(character);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Character character) {
        entityManager.getTransaction().begin();
        entityManager.merge(character);
        entityManager.getTransaction().commit();
    }

}
