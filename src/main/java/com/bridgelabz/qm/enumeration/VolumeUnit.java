package com.bridgelabz.qm.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum VolumeUnit {

    GALLON, LITRE, MILLILITRE;

    public static List<List<Double>> unitConversionTable = new ArrayList<>();

    public double getConversionValue(VolumeUnit toUnit){
        return unitConversionTable.get(this.ordinal()).get(toUnit.ordinal());
    }

    static {
        List<Double> unitConversionRow = new ArrayList<>();
        //Row 1 of Unit Conversion Table
        unitConversionRow.add(1.0);
        unitConversionRow.add(3.785);
        unitConversionRow.add(3785.0);
        unitConversionTable.add(unitConversionRow);
        //Row 2 of Unit Conversion Table
        unitConversionRow = new ArrayList<>();
        unitConversionRow.add(1/3.785);
        unitConversionRow.add(1.0);
        unitConversionRow.add(1000.0);
        unitConversionTable.add(unitConversionRow);
        //Row 3 of Unit Conversion Table
        unitConversionRow = new ArrayList<>();
        unitConversionRow.add(1/3785.0);
        unitConversionRow.add(1/1000.0);
        unitConversionRow.add(1.0);
        unitConversionTable.add(unitConversionRow);
    }
}
