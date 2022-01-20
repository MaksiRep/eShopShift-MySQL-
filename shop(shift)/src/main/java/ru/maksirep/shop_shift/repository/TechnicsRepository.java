package ru.maksirep.shop_shift.repository;

import java.util.List;

public interface TechnicsRepository<T> {

    void addPoint(T t);

    void updatePoint(T t, int id);

    List<T> readPointsByDesc();

    T readPoint(int id);
}