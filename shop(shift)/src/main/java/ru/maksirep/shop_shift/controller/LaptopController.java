package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.Laptop;
import ru.maksirep.shop_shift.service.LaptopService;

import java.util.List;


@RestController
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @Transient
    @PostMapping(value = "/technics/laptop")
    public void addHardDisc(@RequestBody Laptop laptop) {
        laptopService.addPoint(laptop);
    }

    @Transient
    @PutMapping(value = "/technics/laptop/{id}")
    public void redactHardDisc(@RequestBody Laptop laptop, @PathVariable(name = "id") Integer id) {
        laptopService.updatePoint(laptop, id);
    }

    @GetMapping(value = "/technics/laptopSearch")
    public ResponseEntity<List<Laptop>> getHardDriveGoods() {
        List<Laptop> laptops = laptopService.readPointsByDesc();

        if (laptops != null && !laptops.isEmpty()) {
            return new ResponseEntity<>(laptops, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/technics/laptopSearch/{id}")
    public ResponseEntity<Laptop> getHardDrive(@PathVariable(name = "id") Integer id) {
        Laptop laptop = laptopService.readPoint(id);

        if (laptop != null) {
            return new ResponseEntity<>(laptop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
