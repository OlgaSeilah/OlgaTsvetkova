package ru.training.at.hw5;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.training.at.hw5.utils.WebdriverManager;

public class WebdriverHook {
    @Before
    public void setUp() {
        WebdriverManager.setUpDriver();
    }

    @After
    public void tearDown() {
        WebdriverManager.driver.quit();
        WebdriverManager.driver = null;
    }
}
