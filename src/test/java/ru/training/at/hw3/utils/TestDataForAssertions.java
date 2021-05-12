package ru.training.at.hw3.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataForAssertions {
    public static final String EXPECTED_USER_NAME = "ROMAN IOVLEV";
    public static final String EXPECTED_PAGE_TITLE = "Home Page";
    public static final List<String> expectedTextFromLinksInHeader =
            new ArrayList<>(Arrays.asList(
                    "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
    public static final String EXPECTED_1_TXT = "To include good practices\n"
                    + "and ideas from successful\n"
                    + "EPAM project";
    public static final String EXPECTED_2_TXT = "To be flexible and\n"
                    + "customizable";
    public static final String EXPECTED_3_TXT = "To be multiplatform";
    public static final String expected4Txt = "Already have good base\n"
                    + "(about 20 internal and\n"
                    + "some external projects),\n"
                    + "wish to get more…";
    public static final List<String> EXPECTED_TEXT_FROM_LEFT_MENU_ITEMS =
            new ArrayList<>(Arrays.asList("Home", "Contact form",
                    "Service", "Metals & Colors", "Elements packs"));

    public static final String EXPECTED_ROW_IN_LOG_WATER =
            "Water: condition changed to true";
    public static final String EXPECTED_ROW_IN_LOG_WIND =
            "Wind: condition changed to true";
    public static final String EXPECTED_ROW_IN_LOG_SELEN =
            "metal: value changed to Selen";
    public static final String EXPECTED_ROW_IN_LOG_YELLOW =
            "Colors: value changed to Yellow";

}
