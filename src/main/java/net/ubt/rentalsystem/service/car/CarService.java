package net.ubt.rentalsystem.service.car;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.repository.car.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return new ArrayList<>(carRepository.findAll());
    }
}
