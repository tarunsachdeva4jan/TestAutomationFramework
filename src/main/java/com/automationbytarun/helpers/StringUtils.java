package com.automationbytarun.helpers;

import com.automationbytarun.properties.PropertiesLoader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    public static String generateFolderPath(String path) { // extentReports/extentreport.html

        String str = System.getProperty("user.dir") + File.separator + path;
        str = str + File.separator + new SimpleDateFormat("MMM-dd").format(new Date());
        str = str + File.separator + new SimpleDateFormat("hh-mm-ss").format(new Date());
        PropertiesLoader.extentReportPath = str;
        return str;
    }

}
