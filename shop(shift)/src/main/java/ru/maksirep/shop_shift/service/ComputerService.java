package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.Computer;
import ru.maksirep.shop_shift.repository.ComputerRepository;

import java.util.List;

@Service
public class ComputerService implements TechnicsService<Computer> {

    @Autowired
    ComputerRepository computerRepository;

    @Override
    public void addPoint(Computer computer) {
        computerRepository.addPoint(computer);
    }

    @Override
    public void updatePoint(Computer computer, int id) {
        computerRepository.updatePoint(computer, id);
    }

    @Override
    public List<Computer> readPointsByDesc() {
        return computerRepository.readPointsByDesc();
    }

    @Override
    public Computer readPoint(int id) {
        return computerRepository.readPoint(id);
    }
}
