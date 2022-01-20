package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.Laptop;
import ru.maksirep.shop_shift.repository.LaptopRepository;

import java.util.List;

@Service
public class LaptopService implements TechnicsService<Laptop> {

    @Autowired
    LaptopRepository laptopRepository;

    @Override
    public void addPoint(Laptop laptop) {
        laptopRepository.addPoint(laptop);
    }

    @Override
    public void updatePoint(Laptop laptop, int id) {
        laptopRepository.updatePoint(laptop, id);
    }

    @Override
    public List<Laptop> readPointsByDesc() {
        return laptopRepository.readPointsByDesc();
    }

    @Override
    public Laptop readPoint(int id) {
        return laptopRepository.readPoint(id);
    }
}
