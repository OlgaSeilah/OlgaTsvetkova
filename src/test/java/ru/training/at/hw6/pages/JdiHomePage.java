package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class JdiHomePage extends WebPage {

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
