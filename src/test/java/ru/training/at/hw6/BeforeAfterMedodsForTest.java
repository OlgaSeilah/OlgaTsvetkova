package ru.training.at.hw6;

import static com.epam.jdi.light.settings.WebSettings.logger;
import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.pages.JDIHomePage;

public interface BeforeAfterMedodsForTest {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        WebDriverUtils.killAllSeleniumDrivers();
        PageFactory.initSite(JDIHomePage.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

}
