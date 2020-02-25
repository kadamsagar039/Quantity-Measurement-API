package com.bridgelabz.qm.service;

import com.bridgelabz.qm.enumeration.VolumeUnit;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VolumeTest {

    @Test
    void whenGiven0GallonAnd0Gallon_shouldReturnEquals() {
        Volume gallon = new Volume(VolumeUnit.GALLON, 0.0);
        Assert.assertEquals(gallon, new Volume(VolumeUnit.GALLON, 0.0));
    }

    @Test
    void whenGiven1GallonAnd1Gallon_shouldReturnEquals() {
        Volume gallon = new Volume(VolumeUnit.GALLON, 1.0);
        Assert.assertEquals(gallon, new Volume(VolumeUnit.GALLON, 1.0));
    }

    @Test
    void whenGiven1GallonAnd2Gallon_shouldReturnNotEqual() {
        Volume gallon = new Volume(VolumeUnit.GALLON, 1.0);
        Assert.assertNotEquals(gallon, new Volume(VolumeUnit.GALLON, 2.0));
    }

    @Test
    void whenGiven0GallonAnd0Litre_shouldReturnEqual() {
        Volume gallon = new Volume(VolumeUnit.GALLON,0.0);
        Assert.assertEquals(gallon, new Volume(VolumeUnit.LITRE,0.0));
    }

    @Test
    void whenGiven1GallonAnd1Litre_shouldReturnNotEqual() {
        Volume gallon = new Volume(VolumeUnit.GALLON, 1.0);
        Assert.assertNotEquals(gallon, new Volume(VolumeUnit.LITRE, 1.0));
    }

    @Test
    void whenGiven1GallonAnd3Point78Litre_shouldReturnEqual() {
        Volume gallon = new Volume(VolumeUnit.GALLON, 1.0);
        Assert.assertEquals(gallon, new Volume(VolumeUnit.LITRE, 3.785));
    }

    @Test
    void whenGiven0MilliLitreAnd0MilliLitre_shouldReturnEqual() {
        Volume millilitre = new Volume(VolumeUnit.MILLILITRE,0.0);
        Assert.assertEquals(millilitre, new Volume(VolumeUnit.MILLILITRE, 0.0));
    }

    @Test
    void whenGiven1LitreAnd1000MilliLitre_shouldReturnEqual() {
        Volume litre = new Volume(VolumeUnit.LITRE, 1.0);
        Assert.assertEquals(litre, new Volume(VolumeUnit.MILLILITRE, 1000.0));
    }
}
