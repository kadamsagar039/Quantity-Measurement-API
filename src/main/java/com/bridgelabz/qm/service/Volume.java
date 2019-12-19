package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.VolumeUnit;

public class Volume {

    private final double value;
    private final VolumeUnit unit;

    public Volume(VolumeUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public boolean compare(Volume length) {
        double unitConversionValue = this.unit.getConversionValue(length.unit);
        return Double.compare(length.value,this.value*unitConversionValue) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volume)) return false;
        Volume volume = (Volume) o;
        return compare(volume);
    }
}
