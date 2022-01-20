package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.Computer;
import ru.maksirep.shop_shift.service.ComputerService;

import java.util.List;


@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @Transient
    @PostMapping(value = "/technics/computer")
    public void addHardDisc(@RequestBody Computer computer) {
        computerService.addPoint(computer);
    }

    @Transient
    @PutMapping(value = "/technics/computer/{id}")
    public void redactHardDisc(@RequestBody Computer computer, @PathVariable(name = "id") Integer id) {
        computerService.updatePoint(computer, id);
    }

    @GetMapping(value = "/technics/computerSearch")
    public ResponseEntity<List<Computer>> getHardDriveGoods() {
        List<Computer> computers = computerService.readPointsByDesc();

        if (computers != null && !computers.isEmpty()) {
            return new ResponseEntity<>(computers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/technics/computerSearch/{id}")
    public ResponseEntity<Computer> getHardDrive(@PathVariable(name = "id") Integer id) {
        Computer computer = computerService.readPoint(id);

        if (computer != null) {
            return new ResponseEntity<>(computer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
