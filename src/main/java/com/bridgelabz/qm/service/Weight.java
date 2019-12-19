package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.WeightUnit;

import java.util.Objects;

public class Weight {
    public final WeightUnit unit;
    public final double value;

    public Weight(WeightUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public boolean compare(Weight length) {
        double unitConversionValue = this.unit.getConversionValue(length.unit);
        return Double.compare(length.value,this.value*unitConversionValue) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;
        Weight weight = (Weight) o;
        return compare(weight);
    }
}
