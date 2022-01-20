package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.HardDisk;
import ru.maksirep.shop_shift.repository.HardDiskRepository;

import java.util.List;

@Service
public class HardDiskService implements TechnicsService<HardDisk> {

    @Autowired
    HardDiskRepository hardDiskRepository;

    @Override
    public void addPoint(HardDisk hardDisk) {
        hardDiskRepository.addPoint(hardDisk);
    }

    @Override
    public void updatePoint(HardDisk hardDisk, int id) {
        hardDiskRepository.updatePoint(hardDisk, id);
    }

    @Override
    public List<HardDisk> readPointsByDesc() {
        return hardDiskRepository.readPointsByDesc();
    }

    @Override
    public HardDisk readPoint(int id) {
        return hardDiskRepository.readPoint(id);
    }
}
