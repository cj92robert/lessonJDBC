package com.example.lessonjdbc.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {
    private JdbcTemplate jdbcTemplate;

    public DataLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        String sql =
                "CREATE TABLE vehicles(vehicle_id int,brand varchar(255),model varchar(255),production_year int, PRIMARY KEY(vehicle_id) )";
        //jdbcTemplate.update(sql);

    }
}
