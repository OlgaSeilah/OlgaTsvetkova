package ru.training.at.hw3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProperties {

    private static Properties testDataProps;
    private static String testDataPropsPath = "src/test/resources/hw3.properties";

    static {
        testDataProps = new Properties();
        try (InputStream in = new FileInputStream(testDataPropsPath)) {
            testDataProps.load(in);
        } catch (IOException e) {
            System.out.println("Can not load properties file");
            e.printStackTrace();
        }
    }

    public static Properties getTestDataProps() {
        return testDataProps;
    }
}
