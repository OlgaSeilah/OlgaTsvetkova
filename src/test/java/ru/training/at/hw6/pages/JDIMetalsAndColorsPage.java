package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import ru.training.at.hw6.entities.MetalsAndColors;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

import java.util.List;
import java.util.stream.Collectors;

public class JDIMetalsAndColorsPage extends WebPage {

    MetalsAndColorsForm metalsAndColorsForm;

    @FindBy(css = ".results>li")
    public static WebList results;

    public List<String> getResultsInStrings() {
        return results.stream().map(UIElement::getText)
                .collect(Collectors.toList());
    }

    public void fillInFormWithData(MetalsAndColors data) {
        metalsAndColorsForm.fillInWithData(data);
    }
}
