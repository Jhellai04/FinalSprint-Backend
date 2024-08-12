package com.keyin;

import com.keyin.vehicle.Vehicle;
import com.keyin.vehicle.rest.VehicleRestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleRestRepositoryTest {

    @Mock
    private VehicleRestRepository vehicleRestRepository;

    @Test
    @DisplayName("Finding vehicle by brand")
    public void testFindVehicleByBrand() {
        // Arrange
        Vehicle car1 = createVehicle("2021", "Honda", "Pilot", "white", "1HGCM82633A123456", "$30,000.00");
        Vehicle car2 = createVehicle("2012", "Toyota", "Matrix", "blue", "2FMDK4KC6CBA12345", "$20,000.00");

        // Define the mock behavior
        when(vehicleRestRepository.findByBrand("Honda")).thenReturn(List.of(car1));
        when(vehicleRestRepository.findByBrand("Toyota")).thenReturn(List.of(car2));

        // Act
        List<Vehicle> resultHonda = vehicleRestRepository.findByBrand("Honda");
        List<Vehicle> resultToyota = vehicleRestRepository.findByBrand("Toyota");

        // Assert
        assertEquals(1, resultHonda.size(), "Honda vehicle list size should be 1");
        assertEquals("Honda", resultHonda.get(0).getBrand(), "Brand should be Honda");

        assertEquals(1, resultToyota.size(), "Toyota vehicle list size should be 1");
        assertEquals("Toyota", resultToyota.get(0).getBrand(), "Brand should be Toyota");
    }

    private Vehicle createVehicle(String year, String brand, String model, String color, String vin, String cost) {
        Vehicle vehicle = new Vehicle();
        vehicle.setYear(year);
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setColor(color);
        vehicle.setVin(vin);
        vehicle.setCost(cost);
        return vehicle;
    }
}
