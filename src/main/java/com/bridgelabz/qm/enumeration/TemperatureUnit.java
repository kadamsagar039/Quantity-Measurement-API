package com.bridgelabz.qm.enumeration;

import com.bridgelabz.qm.service.Temperature;

public enum TemperatureUnit {
    CELSIUS {
        @Override
        public double convertTo(Temperature temperature) {
            if (temperature.unit.equals(TemperatureUnit.FAHRENHEIT))
                return (temperature.value - 32) * 5 / 9.0;
            return temperature.value;
        }
    }, FAHRENHEIT {
        @Override
        public double convertTo(Temperature temperature) {
            if (temperature.unit.equals(TemperatureUnit.CELSIUS))
                return (temperature.value * 9 / 5.0) + 32;
            return temperature.value;
        }
    };

    abstract public double convertTo(Temperature temperature);
}
