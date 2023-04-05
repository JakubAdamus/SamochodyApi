package com.example.samochody;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarApi {
    private List<Car> cars;

    public CarApi() {
        cars = new ArrayList<>();
        cars.add(new Car(1L,"Audi", "Red" ,LocalDate.of(2012,3,12)));
        cars.add(new Car(2L,"Mercedes", "Black" ,LocalDate.of(2020,12,15)));
    }

    @GetMapping("/all")
    public List<Car> getAll() {
        return cars;
    }

    @GetMapping
    public Car getById(@RequestParam int index) {
        Optional<Car> first = cars.stream()
                .filter(element -> element.getId() == index)
                .findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addCar(@RequestBody Car car) {
        return cars.add(car);
    }

    @PutMapping
    public boolean updateCar(@RequestBody Car updatedCar) {
        Optional<Car> optionalCar = cars.stream()
                .filter(car -> car.getId() == updatedCar.getId())
                .findFirst();
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setModel(updatedCar.getModel());
            car.setColor(updatedCar.getColor());
            car.setProductionDate(updatedCar.getProductionDate());
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping
    public boolean deleteCar(@RequestParam int index) {
        return cars.removeIf(element->element.getId()==index);
    }
}
