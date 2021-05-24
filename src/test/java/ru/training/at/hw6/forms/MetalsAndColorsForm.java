package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.MetalsAndColors;

public class MetalsAndColorsForm {
    @FindBy(name = "custom_radio_odd")
    public RadioButtons summeryOddRadio;

    @FindBy(name = "custom_radio_even")
    public RadioButtons summeryEvenRadio;

    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    public Checklist elementsCheckList;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown colorDropdown;

    @JDropdown(root = ".form-group.metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metalDropdown;

    @JDropdown(root = "#vegetables",
            value = ".btn.btn-default.dropdown-toggle",
            list = "li",
            expand = ".caret")
    public Dropdown vegetablesDropdown;

    @FindBy(css = ".dropdown.salad input")
    public Checklist vegetableList;

    @FindBy(id = "submit-button")
    public Button submitButton;

    public void fillInWithData(MetalsAndColors data) {
        summeryOddRadio.select(data.getSummary()[0]);
        summeryEvenRadio.select(data.getSummary()[1]);

        elementsCheckList.select(data.getElements());

        colorDropdown.select(data.getColor());
        metalDropdown.select(data.getMetals());

        vegetablesDropdown.expand();
        vegetablesDropdown.select(3);
        vegetablesDropdown.select(data.getVegetables());

        submitButton.click();

    }
}
