package at.technikumwien.testvorbereitung;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "t_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color color;

    @Column(nullable = false, length = 25)
    private String carMaker;

    @Column(nullable = false, length = 25)
    private String carName;

    @Column(nullable = false)
    private LocalDate lastCheckup;

    @Column(nullable = false)
    private boolean needsService;

    @JsonIgnore
    public String getName() {
        if(carMaker == null || carMaker.isBlank()) {
            throw new IllegalArgumentException("carMaker is null or empty");
        }
        if(carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("carName is null or empty");
        }
        return carMaker + " " + carName;
    }
}
