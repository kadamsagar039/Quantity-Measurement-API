package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.WeightUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class WeightTest {

    @Test
    void whenGiven0KGAnd0KG_shouldReturnEqual() {
        Weight kg = new Weight(WeightUnit.KG, 0.0);
        Assert.assertEquals(kg, new Weight(WeightUnit.KG, 0.0));
    }

    @Test
    void whenGiven1KGAnd1KG_shouldReturnEqual() {
        Weight kg = new Weight(WeightUnit.KG, 1.0);
        Assert.assertEquals(kg, new Weight(WeightUnit.KG, 1.0));
    }

    @Test
    void whenGiven0kgAnd0Grams_shouldReturnEqual() {
        Weight kg = new Weight(WeightUnit.KG, 0.0);
        Assert.assertEquals(kg, new Weight(WeightUnit.GRAMS, 0.0));
    }
}
