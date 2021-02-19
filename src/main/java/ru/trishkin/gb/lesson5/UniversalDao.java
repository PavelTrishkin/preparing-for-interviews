package ru.trishkin.gb.lesson5;

public interface UniversalDao <T, E> {
    void saveOrUpdate(T obj);

    E save(T obj);

    T findById(E obj);

    void delete(T obj);
}
