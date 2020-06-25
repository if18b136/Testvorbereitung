package at.technikumwien.testvorbereitung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DBInitializer {
    @Autowired
    private CarRepository carRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent() {
        carRepository.saveAll(
                List.of(
                        new Car(
                                null,
                                Color.BLACK,
                                "Renault",
                                "Clio",
                                LocalDate.of(2019,8,14),
                                true
                        ),
                        new Car(
                                null,
                                Color.WHITE,
                                "Range Rover",
                                "Land Cruiser",
                                LocalDate.of(2020,2,20),
                                false
                        ),
                        new Car(
                                null,
                                Color.METALLIC,
                                "Toyota",
                                "Corolla",
                                LocalDate.of(2019,4,18),
                                true
                        )
                )
        );
    }
}
