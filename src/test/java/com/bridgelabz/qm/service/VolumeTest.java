package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.VolumeUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class VolumeTest {

    @Test
    void whenGiven0GallonAnd0Gallon_shouldReturnEquals() {
        Volume volume = new Volume(VolumeUnit.GALLON, 0.0);
        Assert.assertEquals(volume, new Volume(VolumeUnit.GALLON, 0.0));
    }

    @Test
    void whenGiven1GallonAnd1Gallon_shouldReturnEquals() {
        Volume volume = new Volume(VolumeUnit.GALLON, 1.0);
        Assert.assertEquals(volume, new Volume(VolumeUnit.GALLON, 1.0));
    }

    @Test
    void whenGiven1GallonAnd2Gallon_shouldReturnNotEqual() {
        Volume volume = new Volume(VolumeUnit.GALLON, 1.0);
        Assert.assertNotEquals(volume, new Volume(VolumeUnit.GALLON, 2.0));
    }
}
