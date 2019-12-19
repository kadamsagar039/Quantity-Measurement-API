package com.bridgelabz.config;

import com.bridgelabz.qm.enumeration.LengthUnit;
import com.bridgelabz.qm.enumeration.TemperatureUnit;
import com.bridgelabz.qm.enumeration.VolumeUnit;
import com.bridgelabz.qm.enumeration.WeightUnit;

public class ApplicationConfig {

    public enum QUANTITY_TYPE{LENGTH, VOLUME, WEIGHT, TEMPERATURE};
    public static final Class[] quantityTypeClasses = {LengthUnit.class, VolumeUnit.class, WeightUnit.class,
            TemperatureUnit.class};
}
