package ru.training.at.hw4.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProperties {

    private static final Properties TEST_DATA_PROPS;

    static {
        TEST_DATA_PROPS = new Properties();
        String testDataPropsPath = "src/test/resources/hw3.properties";
        try (InputStream in = new FileInputStream(testDataPropsPath)) {
            TEST_DATA_PROPS.load(in);
        } catch (IOException e) {
            System.out.println("Can't load properties file");
            e.printStackTrace();
        }
    }

    public static Properties getTestDataProps() {
        return TEST_DATA_PROPS;
    }
}
