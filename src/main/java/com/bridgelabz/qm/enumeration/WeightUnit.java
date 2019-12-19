package com.bridgelabz.qm.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum WeightUnit {
    KG, GRAMS;

    public static List<List<Double>> unitConversionTable = new ArrayList<>();

    public double getConversionValue(WeightUnit toUnit){
        return unitConversionTable.get(this.ordinal()).get(toUnit.ordinal());
    }

    static {
        List<Double> unitConversionRow = new ArrayList<>();
        //Row 1 in Unit Conversion Table
        unitConversionRow.add(1.0);
        unitConversionRow.add(1000.0);
        unitConversionTable.add(unitConversionRow);
        unitConversionRow = new ArrayList<>();
        unitConversionRow.add(1/1000.0);
        unitConversionRow.add(1.0);
        unitConversionTable.add(unitConversionRow);
    }

}
