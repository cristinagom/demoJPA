package repository;

import entities.Character;

import java.util.List;

public interface Repository<T> {
    T findById(int id);

    List<T> findAll();

    void save(T t);

    void delete(T t);

    void update(T t);

}
