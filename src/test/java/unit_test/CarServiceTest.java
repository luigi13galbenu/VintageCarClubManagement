package unit_test;

import com.VintageCarClub.management.models.dtos.CarResponseDto;
import com.VintageCarClub.management.models.entities.Car;
import com.VintageCarClub.management.repositories.CarRepository;
import com.VintageCarClub.management.services.CarServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    public void whenFindById_thenCarShouldBeFound() {
        Long carId = 1L;
        Car car = new Car();
        car.setId(carId);
        when(carRepository.findById(carId)).thenReturn(Optional.of(car));

        CarResponseDto found = carService.findCarById(carId);

        assertNotNull(found);
        verify(carRepository).findById(carId);
    }
}