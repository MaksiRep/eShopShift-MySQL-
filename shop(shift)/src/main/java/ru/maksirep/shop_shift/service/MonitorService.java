package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.Monitor;
import ru.maksirep.shop_shift.repository.MonitorRepository;

import java.util.List;

@Service
public class MonitorService implements TechnicsService<Monitor> {

    @Autowired
    MonitorRepository monitorRepository;

    @Override
    public void addPoint(Monitor monitor) {
        monitorRepository.addPoint(monitor);
    }

    @Override
    public void updatePoint(Monitor monitor, int id) {
        monitorRepository.updatePoint(monitor, id);
    }

    @Override
    public List<Monitor> readPointsByDesc() {
        return monitorRepository.readPointsByDesc();
    }

    @Override
    public Monitor readPoint(int id) {
        return monitorRepository.readPoint(id);
    }
}
