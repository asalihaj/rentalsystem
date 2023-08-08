package net.ubt.rentalsystem.service.car;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.car.CarBaseDto;
import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.mapper.car.CarMapper;
import net.ubt.rentalsystem.repository.car.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    public List<CarBaseDto> getAllCars() {
        return carRepository.findAll().stream().map(carMapper::toBaseDto).collect(Collectors.toList());
    }
}
