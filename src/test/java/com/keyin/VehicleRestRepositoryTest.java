package com.keyin;

import com.keyin.vehicle.Vehicle;
import com.keyin.vehicle.rest.VehicleRestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VehicleRestRepositoryTest {

    @Mock
    private VehicleRestRepository vehicleRestRepository;

    @Test
    @DisplayName("Finding vehicle by brand")
    public void testFindVehicleByBrand() {
        Vehicle car1 = new Vehicle();
        car1.setYear("2021");
        car1.setBrand("Honda");
        car1.setModel("Pilot");
        car1.setColor("white");
        car1.setVin("1HGCM82633A123456");
        car1.setCost("$30,000.00");

        Vehicle car2 = new Vehicle();
        car2.setYear("2012");
        car2.setBrand("Toyota");
        car2.setModel("Matrix");
        car2.setColor("blue");
        car2.setVin("2FMDK4KC6CBA12345");
        car2.setCost("$20,000.00");

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(car1);
        vehicleList.add(car2);

        // Mock the repository behavior
        when(vehicleRestRepository.findByBrand("Honda")).thenReturn(List.of(car1));
        when(vehicleRestRepository.findByBrand("Toyota")).thenReturn(List.of(car2));

        // Simulate the repository call and check results
        List<Vehicle> resultHonda = vehicleRestRepository.findByBrand("Honda");
        List<Vehicle> resultToyota = vehicleRestRepository.findByBrand("Toyota");

        // Assertions to validate the behavior
        assertEquals(1, resultHonda.size());
        assertEquals("Honda", resultHonda.get(0).getBrand());
        assertEquals(1, resultToyota.size());
        assertEquals("Toyota", resultToyota.get(0).getBrand());
    }
}

