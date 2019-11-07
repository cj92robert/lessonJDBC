package com.example.lessonjdbc.contoller;


import com.example.lessonjdbc.repository.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleRestControler {

    private VehicleDao vehicleDao;

    @Autowired
    public VehicleRestControler(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }


}
