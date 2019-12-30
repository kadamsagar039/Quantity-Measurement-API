package com.bridgelabz.qm.controller;

import com.bridgelabz.qm.config.ApplicationConfig;
import com.bridgelabz.qm.dto.UnitConvertDTO;
import com.bridgelabz.qm.service.IUnitMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuantityMeasurementController {

    @Autowired
    private IUnitMeasurement unitMeasurement;

    @GetMapping("/unit/type")
    public ResponseEntity getAllQuantityTypes(){
        return new ResponseEntity(ApplicationConfig.QUANTITY_TYPE.values(), HttpStatus.OK);
    }

    @GetMapping("/unit/type/{unitType}")
    public  ResponseEntity getAllUnitsByUnitType(@PathVariable("unitType") String unitType){
        return new ResponseEntity(ApplicationConfig.quantityTypeClasses[ApplicationConfig.QUANTITY_TYPE
                .valueOf(unitType).ordinal()].getEnumConstants(),HttpStatus.OK);
    }

    @PostMapping("/unit/convert")
    public ResponseEntity convertUnitValue(@RequestBody UnitConvertDTO unitConvertDTO){
        double convertedValue = unitMeasurement.convert(unitConvertDTO);
        return new ResponseEntity(convertedValue, HttpStatus.OK);
    }
}
