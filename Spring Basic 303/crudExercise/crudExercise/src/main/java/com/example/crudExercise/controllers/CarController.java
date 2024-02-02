

package com.example.crudExercise.controllers;
import com.example.crudExercise.entities.CarEntity;
import com.example.crudExercise.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping(path = "/create")
    public CarEntity createCar(@RequestBody CarEntity car) {
        carRepository.saveAndFlush(car);
        return car;
    }

    @GetMapping(path = "/getall")
    public List<CarEntity> listCar() {
        List<CarEntity> listCars = carRepository.findAll();
        return listCars;
    }

    @GetMapping(path = "/{id}")
    public CarEntity singleCar(@PathVariable Long id) {
        Optional<CarEntity> optionalCar = carRepository.findById(id);
        return optionalCar.orElse(null);
    }

    @PutMapping(path = "/{id}")
    public CarEntity updateCarType(@PathVariable Long id, @RequestParam String type) {
        Optional<CarEntity> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            CarEntity car = optionalCar.get();
            car.setType(type);
            return carRepository.save(car);
        } else {
            return new CarEntity();
        }
    }

    @PutMapping("{id}/updateType")
    public ResponseEntity<CarEntity> updateCarTypeById(@PathVariable Long id, @RequestParam String type) {
        Optional<CarEntity> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            CarEntity car = optionalCar.get();
            car.setType(type);
            carRepository.save(car);
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new CarEntity());
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        Optional<CarEntity> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            carRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllCars() {
        carRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
