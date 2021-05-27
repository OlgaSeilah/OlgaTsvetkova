package ru.training.at.hw6;

import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.pages.JdiSite;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.settings.WebSettings.logger;

public interface BeforeAfterMethodsForTest {

    @BeforeSuite()
    static void setUp() {
        killAllSeleniumDrivers();
        PageFactory.initSite(JdiSite.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }

}
