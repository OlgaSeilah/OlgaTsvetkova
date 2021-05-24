package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Button;
import ru.training.at.hw6.entities.User;


@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")@Title("Home Page")
    public static JDIHomePage jdiHomePage;

    @Url("metals-colors.html")@Title("Metal and Colors")
    public static JDIMetalsAndColorsPage jdiMetalsAndColorsPage;

    @FindBy(css = "li.dropdown.uui-profile-menu")
    public static UIElement loggedUser;

    @FindBy(css = ".logout")
    public static Button logoutButton;

    public static void open() {
        jdiHomePage.open();
    }

    public static void performLogin(User user) {
        jdiHomePage.login(user);
    }

    public static void logoutUser() {
        loggedUser.click();
        logoutButton.click();
    }
}
