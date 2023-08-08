package net.ubt.rentalsystem.controller.car;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.car.CarBaseDto;
import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.service.car.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public List<CarBaseDto> getAllCars() {
        return carService.getAllCars();
    }
}
