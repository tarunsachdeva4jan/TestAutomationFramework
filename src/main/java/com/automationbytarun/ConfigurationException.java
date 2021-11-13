package com.automationbytarun;

public class ConfigurationException extends RuntimeException {
    String exceptionMessage;
    String cause;

    public ConfigurationException(String message) {
        this.cause = message;
    }

    public String toString() {
        exceptionMessage = "Error In Configuration file. Pls check the file for any errors/invalid Input";
        exceptionMessage += "Exception occured due to: " + this.cause;
        return exceptionMessage;
    }
}
