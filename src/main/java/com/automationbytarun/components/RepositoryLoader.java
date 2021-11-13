package com.automationbytarun.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RepositoryLoader {

    static Properties properties;

    public void loadProperties() throws IOException {
        String path = System.getProperty("user.dir") + "//src//main//resources//OR.properties";
        FileInputStream fis = new FileInputStream(new File(path));
        properties = new Properties();
        properties.load(fis);
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static void main(String[] args) throws IOException {
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadProperties();
        System.out.println(loader.getProperty("LoginPage.tbx_Username"));

    }


}
