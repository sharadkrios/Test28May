package com.ciranet.utilities;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvironmentConfig {

    public static Map<String, String> fileandenv = new HashMap<String, String>();
    public static Properties propMain = new Properties();
    public static Properties propPreSet = new Properties();

    private static void environmentVariables() {
        // BrowserType details
        fileandenv.put("BROWSERTYPE", propMain.getProperty("BROWSERTYPE"));

        // Application details
        fileandenv.put("APPLICATIONURL", propMain.getProperty("APPLICATIONURL"));

        // Page load timeout
        fileandenv.put("PAGE_LOAD_TIMEOUT", propMain.getProperty("PAGE_LOAD_TIMEOUT"));
        fileandenv.put("IMPLICIT_WAIT", propMain.getProperty("IMPLICIT_WAIT"));
        
        // Default Element Visibility Max Timeout
        fileandenv.put("DEFAULT_VISIBILITY_MAX_TIMEOUT", propMain.getProperty("DEFAULT_VISIBILITY_MAX_TIMEOUT"));

        // FilePath
        fileandenv.put("TESTDATA_PATH", propMain.getProperty("TESTDATA_PATH"));
        fileandenv.put("REPORT_LOCATION", propMain.getProperty("REPORT_LOCATION"));
        fileandenv.put("SCREEN_SHOT_PATH", propMain.getProperty("SCREEN_SHOT_PATH"));
    }

    public static Map<String, String> environmentSetup() {

    	// If env property isnt set then it defaults to sandbox
        String environment = System.getProperty("env", "sandbox");

        LoggerManager.info("------- Selected environment ------- " + environment);

        try {
            String propFileName = "envProperties/" + environment + ".properties";

            InputStream inputStream = EnvironmentConfig.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                propMain.load(inputStream);
                environmentVariables();
            } else {
                throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {

            LoggerManager.error("+++++++++ Exception in environmentSetup() +++++++++ " + e.getMessage());

            e.printStackTrace();
        }

        return fileandenv;
    }

    public static Map<String, String> getConfigReader() {

        if (fileandenv == null || fileandenv.isEmpty()) {

            fileandenv = environmentSetup();

        }

        return fileandenv;
    }
}