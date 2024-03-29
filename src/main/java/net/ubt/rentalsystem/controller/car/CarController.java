package net.ubt.rentalsystem.controller.car;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.car.*;
import net.ubt.rentalsystem.service.car.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<CarBaseDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/calendar")
    public ResponseEntity<List<CarCalendarDto>> getAllCalendarCars() {
        List<CarCalendarDto> cars = carService.getCalendarCarList();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/available")
    public List<CarOfferDto> getAllAvailableCars() {
        return carService.getAvailableCars();
    }

    @GetMapping("/{id}/details")
    public CarOfferDetailsDto getCarOfferDetails(@PathVariable UUID id) {
        return carService.getCarOfferDetails(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createCar(@RequestBody CreateCarDto createCarDto) {
        carService.createCar(createCarDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateCarData(@PathVariable UUID id, @RequestBody UpdateCarDto updateCarDto) {
        carService.updateCarData(id, updateCarDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCarById(@PathVariable UUID id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
