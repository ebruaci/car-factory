package com.vodafone.controller;

import com.vodafone.cars.Cabrio;
import com.vodafone.cars.Car;
import com.vodafone.cars.Hatchback;
import com.vodafone.cars.Sedan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carFactory")
public class CarFactoryController {

    @GetMapping("/{type}")
    public String getCarType(@PathVariable String type) {
        Car car;
        switch (type) {
            case "cabrio":
                car = new Cabrio();
                break;
            case "sedan":
                car = new Sedan();
                break;
            case "hatchback":
                car = new Hatchback();
                break;
            default:
                return "Invalid type";
        }
        return car.getType() + " Car has produced";
    }
}
