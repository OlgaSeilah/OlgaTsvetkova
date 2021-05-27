package ru.training.at.hw6;

import org.testng.annotations.Test;
import ru.training.at.hw6.actions.ActionsAndAllureReport;
import ru.training.at.hw6.dataprovider.DataProviderForJdiTest;
import ru.training.at.hw6.entities.MetalsAndColors;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.enums.HeaderMenuItems;

import static ru.training.at.hw6.pages.JdiSite.*;

public class JdiTest implements BeforeAfterMethodsForTest {

    @Test(dataProviderClass = DataProviderForJdiTest.class, dataProvider = "metalsAndColorsDataSet")
    public void metalsColorsFormFillTest(MetalsAndColors testData) {
        ActionsAndAllureReport.openHomePage();
        ActionsAndAllureReport.login(User.ROMAN);
        ActionsAndAllureReport.selectHeaderItem(HeaderMenuItems.METALS_COLORS);
        ActionsAndAllureReport.fillForm(metalAndColorForm, testData);
        ActionsAndAllureReport.verifyResults(MetalsAndColors.resultsList(testData));
        ActionsAndAllureReport.logout();
    }

}