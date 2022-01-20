package ru.maksirep.shop_shift.service;

import java.util.List;

public interface TechnicsService <T> {

    void addPoint(T t);

    void updatePoint(T t, int id);

    List<T> readPointsByDesc();

    T readPoint(int id);
}
