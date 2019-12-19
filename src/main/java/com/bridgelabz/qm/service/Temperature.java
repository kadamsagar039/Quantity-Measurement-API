package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.TemperatureUnit;

public class Temperature {

    public final TemperatureUnit unit;
    public final double value;

    public Temperature(TemperatureUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public boolean compare(Temperature temperature) {
        return Double.compare(this.value, this.unit.convertTo(temperature)) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature)) return false;
        Temperature that = (Temperature) o;
        return compare(that);
    }
}
