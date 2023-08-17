package net.ubt.rentalsystem.util;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.entity.car.Period;
import net.ubt.rentalsystem.entity.car.Season;
import net.ubt.rentalsystem.repository.car.PeriodRepository;
import net.ubt.rentalsystem.repository.car.SeasonRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceCalculator {
    private final SeasonRepository seasonRepository;
    private final PeriodRepository periodRepository;
    public BigDecimal calculateTotalAmount(Car car, OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        int totalDays = getTotalDays(rentalDate, returnDate);
        car.setRentalRate(getChange(car, rentalDate, returnDate));
        return car.getRentalRate().multiply(BigDecimal.valueOf(totalDays));
    }

    private BigDecimal getChange(Car car, OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        BigDecimal seasonChange = getSeasonChange(car, rentalDate, returnDate);
        List<Period> periods = periodRepository.findAll();
        int totalDays = getTotalDays(rentalDate, returnDate);
        return getPeriodChange(periods, seasonChange, totalDays);
    }

    private int getTotalDays(OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        Duration difference = Duration.between(rentalDate, returnDate);
        long minutes = difference.toMinutes();
        return (int) Math.ceil((double) minutes / 1440);
    }

    private BigDecimal getSeasonChange(Car car, OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        Season season = seasonRepository.findAll()
                .stream().filter(s ->
                        areDatesInRange(rentalDate, s.getStartDate(), returnDate, s.getEndDate()))
                .findFirst().orElse(null);
        if (season == null) {
            return car.getRentalRate();
        }
        return calculatePriceValue(car.getRentalRate(), season.getChangeValue(), season.getIsFixed());
    }

    private BigDecimal getPeriodChange(List<Period> periods, BigDecimal rentalRate, int totalDays) {
        Period period = getPeriod(periods, totalDays);
        if (period != null) {
            return calculatePriceValue(rentalRate, period.getPriceChange(), period.getIsFixed());
        }
        return rentalRate;
    }

    private Period getPeriod(List<Period> periods, int totalDays) {
        Period period = null;
        for (Period p : periods) {
            int startDay = p.getStartDay();
            int endDay = p.getEndDay();
            if (totalDays >= startDay && (totalDays <= endDay || endDay == 0)) {
                period = p;
            }
        }
        return period;
    }

    private boolean areDatesInRange(OffsetDateTime rentalDate, OffsetDateTime startDate,
                                    OffsetDateTime returnDate, OffsetDateTime endDate) {
        return rentalDate.isAfter(startDate) && returnDate.isBefore(endDate);
    }

    private BigDecimal calculatePriceValue(BigDecimal rentalPrice, int change, boolean isFixed) {
        if (isFixed) {
            return rentalPrice.add(BigDecimal.valueOf(change));
        } else {
            double percentage = ((double) (100 + change) / 100);
            return rentalPrice.multiply(BigDecimal.valueOf(percentage));
        }
    }
}
