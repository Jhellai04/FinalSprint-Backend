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


    public List<Vehicle> findByBrand(@Param("brand")String brand);
    public List<Vehicle> findByModel(@Param("model")String model);
    public List<Vehicle> findByVin(@Param("vin")String vin);
    public List<Vehicle> findByYear(@Param("year")String year);
    public List<Vehicle> findByColour(@Param("colour")String colour);
    public List<Vehicle> findByCost(@Param("cost")String cost);
    public List<Vehicle> findByCountry(@Param("country")String country);
    public List<Vehicle> findByCity(@Param("city")String city);
    public List<Vehicle> findByAddress(@Param("address")String address);

}
