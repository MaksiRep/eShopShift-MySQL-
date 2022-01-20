package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.Monitor;
import ru.maksirep.shop_shift.service.MonitorService;

import java.util.List;


@RestController
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @Transient
    @PostMapping(value = "/technics/monitor")
    public void addHardDisc(@RequestBody Monitor monitor) {
        monitorService.addPoint(monitor);
    }

    @Transient
    @PutMapping(value = "/technics/monitor/{id}")
    public void redactHardDisc(@RequestBody Monitor monitor, @PathVariable(name = "id") Integer id) {
        monitorService.updatePoint(monitor, id);
    }

    @GetMapping(value = "/technics/monitorSearch")
    public ResponseEntity<List<Monitor>> getHardDriveGoods() {
        List<Monitor> monitors = monitorService.readPointsByDesc();

        if (monitors != null && !monitors.isEmpty()) {
            return new ResponseEntity<>(monitors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/technics/monitorSearch/{id}")
    public ResponseEntity<Monitor> getHardDrive(@PathVariable(name = "id") Integer id) {
        Monitor monitor = monitorService.readPoint(id);

        if (monitor != null) {
            return new ResponseEntity<>(monitor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
