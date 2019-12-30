package com.bridgelabz.qm.service;

import com.bridgelabz.qm.dto.UnitConvertDTO;
import com.bridgelabz.qm.enumeration.LengthUnit;
import com.bridgelabz.qm.enumeration.VolumeUnit;
import com.bridgelabz.qm.enumeration.WeightUnit;
import org.springframework.stereotype.Service;

@Service
public class UnitMeasurement implements IUnitMeasurement{

    @Override
    public double convert(UnitConvertDTO unitConvertDTO){
        switch (unitConvertDTO.unitType.toString()){
            case "LENGTH" :
                return new Length(LengthUnit.valueOf(unitConvertDTO.initialUnit),unitConvertDTO.initialValue)
                        .convertTo(LengthUnit.valueOf(unitConvertDTO.outputUnit));
            case "VOLUME" :
                return new Volume(VolumeUnit.valueOf(unitConvertDTO.initialUnit),unitConvertDTO.initialValue)
                        .convertTo(VolumeUnit.valueOf(unitConvertDTO.outputUnit));
            case "WEIGHT" :
                return new Weight(WeightUnit.valueOf(unitConvertDTO.initialUnit),unitConvertDTO.initialValue)
                        .convertTo(WeightUnit.valueOf(unitConvertDTO.outputUnit));
//            case "TEMPERATURE" : return new Temperature(TemperatureUnit.valueOf(unitConvertDTO.initialUnit),unitConvertDTO.initialValue);
        }
        return 0;
    }
}
