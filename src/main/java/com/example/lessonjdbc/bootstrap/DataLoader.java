package com.example.lessonjdbc.bootstrap;

import com.example.lessonjdbc.model.Vehicle;
import com.example.lessonjdbc.repository.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private JdbcTemplate jdbcTemplate;
    private VehicleDao vehicleDao;

    @Autowired
    public DataLoader(JdbcTemplate jdbcTemplate, VehicleDao vehicleDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.vehicleDao = vehicleDao;
    }

    @Override
    public void run(String... args) throws Exception {

        String sql =
                "CREATE TABLE vehicles(vehicle_id int NOT NULL AUTO_INCREMENT,brand varchar(255),model varchar(255),production_year int,color varchar(255), PRIMARY KEY(vehicle_id) )";
        //jdbcTemplate.update(sql);

        Vehicle vehicle1 = new Vehicle("bmw", "e46", 2009L, "BLACK");

        //vehicleDao.save(vehicle1);
    }
}
