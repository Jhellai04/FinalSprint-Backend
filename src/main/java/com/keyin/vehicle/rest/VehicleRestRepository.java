package com.keyin.vehicle.rest;

import com.keyin.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "vehicle", path = "vehicle")
public interface VehicleRestRepository extends JpaRepository<Vehicle, Long> {


    List<Vehicle> findByBrand(@Param("brand") String brand);
    List<Vehicle> findByModel(@Param("model") String model);
    List<Vehicle> findByVin(@Param("vin") String vin);
    List<Vehicle> findByYear(@Param("year") String year);
    List<Vehicle> findByColor(@Param("color") String colour);
    List<Vehicle> findByCost(@Param("cost") String cost);


}
