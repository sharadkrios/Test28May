package com.ciranet.testrunner;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.InputStream;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        // Get the environment parameter or default to 'sandbox'
        String environment = System.getProperty("env", "sandbox");

        // Get the suite XML file parameter or default to 'testscenarios/loginLogout.xml'
        String xmlFileName = System.getProperty("suiteXmlFile", "testscenarios/loginLogout.xml");

        // Print the environment and TestNG XML file name for verification
        System.out.println("Environment: " + environment);
        System.out.println("Running TestNG XML: " + xmlFileName);

        // Load the TestNG XML file from the classpath
        InputStream inputStream = TestRunner.class.getClassLoader().getResourceAsStream(xmlFileName);
        if (inputStream == null) {
            System.err.println("TestNG XML file not found in classpath: " + xmlFileName);
            return;
        }

        // Parse the XML file into a list of XmlSuite objects
        List<XmlSuite> suites = new Parser(inputStream).parseToList();

        // Set up and run the TestNG suite using the parsed XmlSuite objects
        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);

        // Pass the environment to the tests via system properties or other means
        System.setProperty("env", environment);

        // Run the TestNG suite
        testng.run();
    }
}