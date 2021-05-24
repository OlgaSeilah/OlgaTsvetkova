package ru.training.at.hw6;

import org.testng.annotations.Test;
import ru.training.at.hw6.dataprovider.DataProviderForJDITest;
import ru.training.at.hw6.entities.MetalsAndColors;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.pages.JDIHomePage;
import ru.training.at.hw6.pages.JdiSite;

import java.util.ArrayList;
import java.util.List;

import static ru.training.at.hw6.pages.JdiSite.jdiHomePage;
import static ru.training.at.hw6.pages.JdiSite.jdiMetalsAndColorsPage;

@Test(dataProviderClass = DataProviderForJDITest.class, dataProvider = "metalsAndColorsDataSet")
public class JdiTest implements BeforeAfterMedodsForTest {


    public void TestFillInDifferentFormsOnMetalsAndColorsPage() {
        JdiSite.open();
        JdiSite.performLogin(User.ROMAN);
        jdiHomePage.goToMetalAndColorsPage();

        List<String> actualResultsInStrings = jdiMetalsAndColorsPage.getResultsInStrings();
        List<String> expectedResultsInString = getExpectedResultInString(data);


    }


    private List<String> getExpectedResultInString(MetalsAndColors data) {
        List<String> result = new ArrayList<>();
        result.add("Summary: " + (Integer.parseInt(data.getSummary()[0])
                + Integer.parseInt(data.getSummary()[1])));
        result.add("Color: " + data.getColor());
        result.add("Metal: " + data.getMetals());

        String elementsString = "Elements: ";
        for (int i = 0; i < data.getElements().length; i++) {
            elementsString = elementsString + data.getElements()[i] + ", ";
        }
        result.add(elementsString.substring(0, elementsString.length() - 2));

        String vegetableString = "Vegetables: ";
        for (int i = 0; i < data.getVegetables().length; i++) {
            vegetableString = vegetableString + data.getVegetables()[i] + ", ";
        }
        result.add(vegetableString.substring(0, vegetableString.length() - 2));

        return result;
    }

}