package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.TemperatureUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TemperatureTest {

    @Test
    void whenGiven0CelsiusAnd0Celsius_shouldReturnEqual() {
        Temperature celsius = new Temperature(TemperatureUnit.CELSIUS, 0.0);
        Assert.assertEquals(celsius, new Temperature(TemperatureUnit.CELSIUS, 0.0));
    }

    @Test
    void whenGiven0FahrenheitAnd0Fahrenheit_shouldReturnEqual() {
        Temperature fahrenheit = new Temperature(TemperatureUnit.FAHRENHEIT, 0.0);
        Assert.assertEquals(fahrenheit, new Temperature(TemperatureUnit.FAHRENHEIT, 0.0));
    }

    @Test
    void whenGiven1CelsiusAnd1Fahrenheit_shouldReturnNotEqual() {
        Temperature celsius = new Temperature(TemperatureUnit.CELSIUS, 1.0);
        Assert.assertNotEquals(celsius, new Temperature(TemperatureUnit.FAHRENHEIT, 1.0));
    }

    @Test
    void whenGiven212FahrenheitAnd100Celsius_shouldReturnEqual() {
        Temperature fahrenheit = new Temperature(TemperatureUnit.FAHRENHEIT, 212);
        Assert.assertEquals(fahrenheit, new Temperature(TemperatureUnit.CELSIUS, 100));
    }

    @Test
    void whenGiven100CelsiusAnd212Fahrenheit_shouldReturnEqual() {
        Temperature celsius = new Temperature(TemperatureUnit.CELSIUS, 100);
        Assert.assertEquals(celsius, new Temperature(TemperatureUnit.FAHRENHEIT, 212));
    }
}
