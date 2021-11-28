package com.automationbytarun.helpers;

import com.github.javafaker.Faker;

public class DataGenerator {


    public static String getUsername() {
        return Faker.instance().name().firstName() + "_" + Faker.instance().name().lastName();
    }

    public static String getPassword() {
        return Faker.instance().internet().password();
    }

    public static String getEmailAddress() {
        return Faker.instance().internet().emailAddress();
    }

    public static String getFullName() {
        return Faker.instance().name().fullName();
    }

    public static String getPhoneNumber() {
        return Faker.instance().phoneNumber().cellPhone();
    }

}

