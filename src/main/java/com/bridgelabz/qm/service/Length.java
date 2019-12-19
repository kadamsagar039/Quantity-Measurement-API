package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.LengthUnit;

public class Length {

    private final LengthUnit unit;
    private final double value;

    public Length(LengthUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public boolean compare(Length length) {
        double unitConversionValue = this.unit.getConversionValue(length.unit);
        return Double.compare(length.value,this.value*unitConversionValue) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length length = (Length) o;
        return compare(length);
    }
}
