package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.VolumeUnit;

import java.util.Objects;

public class Volume {

    private final double value;
    private final VolumeUnit unit;

    public Volume(VolumeUnit unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volume)) return false;
        Volume volume = (Volume) o;
        return Double.compare(volume.value, value) == 0;
    }
}
