package integration_test;

import com.VintageCarClub.management.controllers.CarController;
import com.VintageCarClub.management.services.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CarControllerTest {

    private MockMvc mockMvc;
    private CarService carService;
    private CarController carController;

    @BeforeEach
    void setUp() {
        carService = mock(CarService.class);
        carController = new CarController(carService);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void whenGetCar_thenStatus200() throws Exception {
        mockMvc.perform(get("/cars/1"))
                .andExpect(status().isOk());

    }
}