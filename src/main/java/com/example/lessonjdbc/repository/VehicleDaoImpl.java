package com.example.lessonjdbc.repository;

import com.example.lessonjdbc.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VehicleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from vehicles", Integer.class);
    }

    @Override
    public int save(Vehicle vehicle) {
        return jdbcTemplate.update(
                "INSERT INTO vehicles (brand,model,production_year,color) values(?,?,?,?) ",
                vehicle.getBrand(), vehicle.getModel(), vehicle.getProductionYear(), vehicle.getColor());
    }

    @Override
    public int update(Vehicle vehicle) {
        return jdbcTemplate.update(
                "UPDATE vehicles SET brand=?, model=?,production_year=?, color=? where vehicle_id=?",
                vehicle.getBrand(), vehicle.getModel(), vehicle.getProductionYear(), vehicle.getColor(), vehicle.getVehicleId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM vehicles WHERE vehicle_id=?",
                id);
    }

    @Override
    public List<Vehicle> findAll() {
        return jdbcTemplate.query("SELECT * FROM vehicles", (rs, rowNum) ->
                new Vehicle(rs.getLong("vehicle_id"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getLong("production_year"),
                        rs.getString("color")
                )
        );
    }

    @Override
    public List<Vehicle> findByProductionYearBetween(Long yearBeg, Long yearEnd) {
        return jdbcTemplate.query("SELECT * FROM vehicles WHERE production_year BETWEEN ? AND ?", (rs, rowNum) ->
                        new Vehicle(rs.getLong("vehicle_id"),
                                rs.getString("brand"),
                                rs.getString("model"),
                                rs.getLong("production_year"),
                                rs.getString("color")
                        ),
                yearBeg, yearEnd
        );
    }

    @Override
    public Vehicle findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM vehicles where vehicle_id=?", (rs, rowNum) ->
                        new Vehicle(rs.getLong("vehicle_id"),
                                rs.getString("brand"),
                                rs.getString("model"),
                                rs.getLong("production_year"),
                                rs.getString("color")
                        ),
                id

        );
    }
}
