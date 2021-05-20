package ru.training.at.hw5;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.pages.DiffElementsPage;
import ru.training.at.hw5.pages.HomePage;

import java.util.List;
import java.util.Properties;

public class ParentPageForCucumberSteps extends BaseTest {
    HomePage homePage;
    DiffElementsPage diffElementsPage;
    Properties properties;
    public BaseTest baseTest;


    protected String login;
    protected String password;

    protected List<String> expectedTextFromLinksInHeader;
    protected List<String> expectedTextFromLeftMenuItems;


//    public ParentPageForCucumberSteps (WebDriver driver, Properties properties,
//                        List<String> expectedTextFromLinksInHeader,
//                        List<String> expectedTextFromLeftMenuItems,
//                        String login, String password) {
//        homePage = new HomePage(driver);
//        diffElementsPage = new DiffElementsPage(driver);
//        this.login = login;
//        this.properties = properties;
//        this.password = password;
//        this.expectedTextFromLeftMenuItems = expectedTextFromLeftMenuItems;
//        this.expectedTextFromLinksInHeader = expectedTextFromLinksInHeader;
//
//    }

}
