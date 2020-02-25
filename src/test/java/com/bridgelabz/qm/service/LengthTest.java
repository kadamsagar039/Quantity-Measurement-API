package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.LengthUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LengthTest {
    @Test
    public void whenGivenTwoSameFeetValueObject_ifEqual_shouldReturnTrue() {
        Length feet = new Length(LengthUnit.FEET,0);
        Assert.assertEquals(feet,new Length(LengthUnit.FEET,0));
    }

    @Test
    public void whenGivenTwoDifferentFeetValueObject_shouldReturnFalse() {
        Length feet = new Length(LengthUnit.FEET, 0.0);
        Assert.assertNotEquals(feet,new Length(LengthUnit.FEET,1.0));
    }

    @Test
    public void whenGivenTwoSameInchValueObjects_shouldReturnTrue() {
        Length inch = new Length(LengthUnit.INCH, 0.0);
        Assert.assertEquals(inch,new Length(LengthUnit.INCH, 0.0));
    }

    @Test
    public void whenGivenTwoDifferentInchObjects_shouldReturnFalse() {
        Length inch = new Length(LengthUnit.INCH, 0.0);
        Assert.assertNotEquals(inch,new Length(LengthUnit.INCH, 1.0));
    }

    @Test
    public void whenGivenFeetAndInchObjects_shouldNotEquals() {
        Length feet = new Length(LengthUnit.FEET,1.0);
        Assert.assertNotEquals(feet, new Length(LengthUnit.INCH,1.0));
    }

    @Test
    public void whenGiven0FeetAnd0Inch_shouldReturnEquals() {
        Length feet = new Length(LengthUnit.FEET,0.0);
        Assert.assertEquals(feet, new Length(LengthUnit.INCH,0.0));
    }

    @Test
    public void whenGiven1FeetAnd1Feet_shouldReturnEquals() {
        Length feet = new Length(LengthUnit.FEET,1.0);
        Assert.assertEquals(feet,new Length(LengthUnit.FEET,1.0));
    }

    @Test
    public void whenGiven0FeetAnd0Yard_shouldReturnEquals() {
        Length feet = new Length(LengthUnit.FEET, 0.0);
        Assert.assertEquals(feet, new Length(LengthUnit.YARD, 0.0));
    }

    @Test
    public void whenGiven1FeetAnd1Yard_shouldReturnNotEquals() {
        Length feet = new Length(LengthUnit.FEET, 1.0);
        Assert.assertNotEquals(feet, new Length(LengthUnit.YARD,1.0));
    }

    @Test
    public void whenGiven3FeetAnd1Yard_shouldReturnEquals() {
        Length feet = new Length(LengthUnit.FEET,3.0);
        Assert.assertEquals(feet, new Length(LengthUnit.YARD, 1.0));
    }

    @Test
    public void whenGiven1InchAnd1Yard_shouldReturnNotEquals() {
        Length inch = new Length(LengthUnit.INCH,1.0);
        Assert.assertNotEquals(inch, new Length(LengthUnit.YARD, 1.0));
    }

    @Test
    public void whenGiven1YardAnd36Inch_shouldReturnEquals() {
        Length yard = new Length(LengthUnit.YARD,1.0);
        Assert.assertEquals(yard, new Length(LengthUnit.INCH, 36.0));
    }

    @Test
    public void whenGiven36InchAnd1Yard_shouldReturnEquals() {
        Length inch = new Length(LengthUnit.INCH,36.0);
        Assert.assertEquals(inch, new Length(LengthUnit.YARD, 1.0));
    }

    @Test
    public void whenGiven1YardAnd3Feet_shouldReturnEquals() {
        Length yard = new Length(LengthUnit.YARD,1.0);
        Assert.assertEquals(yard, new Length(LengthUnit.FEET, 3.0));
    }

    @Test
    public void whenGiven2InchAnd5Centimetre_shouldReturnEquals() {
        Length inch = new Length(LengthUnit.INCH,2.0);
        Assert.assertEquals(inch, new Length(LengthUnit.CENTIMETRE, 5.08));
    }
}
