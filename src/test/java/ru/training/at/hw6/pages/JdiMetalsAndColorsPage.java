package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;

import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class JdiMetalsAndColorsPage extends WebPage {

    @UI(".panel-body-list.results")
    public static List<WebElement> results;
}