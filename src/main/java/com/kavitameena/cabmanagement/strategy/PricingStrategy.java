package com.kavitameena.cabmanagement.strategy;

import com.kavitameena.cabmanagement.model.City;
import org.springframework.stereotype.Component;

// 1. Based on per km rate
// 2. Price surging based on weather, traffic
@Component
public class PricingStrategy {

    public static double perKmRate;

    public static double getPerKmRate() {
        return perKmRate;
    }

    public static void setPerKmRate(double perKmRate) {
        PricingStrategy.perKmRate = perKmRate;
    }

    public Double calculatePrice(City source, City destination) {
        return calculateDistance(source, destination) * getPerKmRate();
    }

    private Double calculateDistance(City source, City destination) {
        return Math.sqrt(Math.pow(source.getX() - destination.getX(), 2)
                + Math.pow(source.getY() - destination.getY(), 2));
    }

}
