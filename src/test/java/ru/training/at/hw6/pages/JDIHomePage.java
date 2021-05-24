package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.LoginForm;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

public class JDIHomePage extends WebPage {

    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(css = ".uui-navigation.nav")
    public Menu headerMenu;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void goToMetalAndColorsPage() {
        headerMenu.select("Metals & Colors");
    }

}
