package com.example.lessonjdbc.contoller;


import com.example.lessonjdbc.model.Vehicle;
import com.example.lessonjdbc.repository.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class VehicleRestController {

    private VehicleDao vehicleDao;

    @Autowired
    public VehicleRestController(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @GetMapping("/")
    ResponseEntity<List<Vehicle>> getVehicles() {
        List<Vehicle> list = vehicleDao.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/between/")
    ResponseEntity<List<Vehicle>> getVehicleByData(@RequestParam long dataBeg, @RequestParam long dataEnd) {
        List<Vehicle> list = vehicleDao.findByProductionYearBetween(dataBeg, dataEnd);
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    ResponseEntity<Vehicle> getVehicleById(@PathVariable long id) {
        Vehicle vehicle1 = vehicleDao.findById(id);
        if (vehicle1 != null)
            return new ResponseEntity<>(vehicle1, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/")
    ResponseEntity add(@RequestBody Vehicle vehicle) {
        if (vehicleDao.save(vehicle) > 0) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable long id, @RequestBody Vehicle vehicle) {
        if (vehicleDao.update(vehicle) > 0)
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable long id) {
        if (vehicleDao.deleteById(id) == 0)
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity(HttpStatus.OK);

    }

}
