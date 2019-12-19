package com.bridgelabz.qm.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum LengthUnit {
    FEET, INCH, YARD, CENTIMETRE;

    public static List<List<Double>> unitConversionTable = new ArrayList<>();

    public double getConversionValue(LengthUnit toUnit){
        return unitConversionTable.get(this.ordinal()).get(toUnit.ordinal());
    }

    static{
        List<Double> unitConversionRow = new ArrayList<>();
        //Row 1 of UnitConversionTable
        unitConversionRow.add(1.0);
        unitConversionRow.add(12.0);
        unitConversionRow.add(1/3.0);
        unitConversionRow.add(30.48);
        unitConversionTable.add(unitConversionRow);
        //Row 2 of UnitConversionTable
        unitConversionRow = new ArrayList<>();
        unitConversionRow.add(1/12.0);
        unitConversionRow.add(1.0);
        unitConversionRow.add(1/36.0);
        unitConversionRow.add(2.54);
        unitConversionTable.add(unitConversionRow);
        //Row 3 of UnitConversionTable
        unitConversionRow = new ArrayList<>();
        unitConversionRow.add(3.0);
        unitConversionRow.add(36.0);
        unitConversionRow.add(1.0);
        unitConversionRow.add(91.44);
        unitConversionTable.add(unitConversionRow);
        //Row 4 of UnitConversionTable
        unitConversionRow = new ArrayList<>();
        unitConversionRow.add(1/30.48);
        unitConversionRow.add(1/2.54);
        unitConversionRow.add(1/91.44);
        unitConversionRow.add(1.0);
        unitConversionTable.add(unitConversionRow);
    }
}
