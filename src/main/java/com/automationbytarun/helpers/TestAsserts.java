package com.automationbytarun.helpers;

import org.testng.Assert;

public class TestAsserts {
    public static void checkIfValuesAreEqual(String value1, String value2) {
        Assert.assertEquals(value1, value2, "Value [" + value1 + "] and Value2 [" + value2 + "] are not equal");
    }

    public static void checkIfContains(String valueToCheck, String value) {
        Assert.assertTrue(value.contains(valueToCheck), "Value[" + value + "] not found in String [" + valueToCheck + "]");
    }

}
