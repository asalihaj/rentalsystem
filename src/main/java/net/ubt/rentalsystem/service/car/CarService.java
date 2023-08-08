package net.ubt.rentalsystem.service.car;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.car.CarBaseDto;
import net.ubt.rentalsystem.dto.car.CarOfferDto;
import net.ubt.rentalsystem.entity.car.Status;
import net.ubt.rentalsystem.mapper.car.CarMapper;
import net.ubt.rentalsystem.repository.car.CarRepository;
import net.ubt.rentalsystem.util.PriceCalculator;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    private final PriceCalculator priceCalculator;
    public List<CarBaseDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::toBaseDto)
                .collect(Collectors.toList());
    }

    public List<CarBaseDto> getAvailableCars() {
        return carRepository.findAllByStatus(Status.AVAILABLE)
                .stream()
                .map(car -> {
                    CarOfferDto carOffer = carMapper.toOfferDto(car);
                    carOffer.setPrice(
                            priceCalculator.calculateTotalAmount(
                                            car,
                                            OffsetDateTime.now(),
                                            OffsetDateTime.now().plus(5, ChronoUnit.DAYS)
                                    )
                    );

                    return carOffer;
                })
                .collect(Collectors.toList());
    }
}