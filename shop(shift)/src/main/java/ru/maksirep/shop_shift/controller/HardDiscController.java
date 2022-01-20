package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.HardDisk;
import ru.maksirep.shop_shift.service.HardDiskService;

import java.util.List;


@RestController
public class HardDiscController {

    @Autowired
    private HardDiskService hardDiskService;

    @Transient
    @PostMapping(value = "/technics/hardDisc")
    public void addHardDisc(@RequestBody HardDisk hardDisk) {
        hardDiskService.addPoint(hardDisk);
    }

    @Transient
    @PutMapping(value = "/technics/hardDisc/{id}")
    public void redactHardDisc(@RequestBody HardDisk hardDisk, @PathVariable(name = "id") Integer id) {
        hardDiskService.updatePoint(hardDisk, id);
    }

    @GetMapping(value = "/technics/hardDiscSearch")
    public ResponseEntity<List<HardDisk>> getHardDriveGoods() {
        List<HardDisk> hardDisks = hardDiskService.readPointsByDesc();

        if (hardDisks != null && !hardDisks.isEmpty()) {
            return new ResponseEntity<>(hardDisks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/technics/hardDiscSearch/{id}")
    public ResponseEntity<HardDisk> getHardDrive(@PathVariable(name = "id") Integer id) {
        HardDisk hardDisk = hardDiskService.readPoint(id);

        if (hardDisk != null) {
            return new ResponseEntity<>(hardDisk, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
