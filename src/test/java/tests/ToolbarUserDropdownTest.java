package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.User;


public class ToolbarUserDropdownTest extends BaseTest {
    private static final User TEST_USER = new User("event2", "private");
    private static final String ENGLISH = "English";
    private static final String RUSSIAN = "Русский";

    @Test
    void changeLanguageTest() {
        MainPage mainPage = new LoginPage(webDriver).login(TEST_USER);
        mainPage.openChangeLanguageModal().chooseLanguage(ENGLISH);
        // mainPage was changed, so we initialize it again
        mainPage = new MainPage(webDriver);
        Assertions.assertEquals("My settings", mainPage.getSettingsText());

        mainPage.openChangeLanguageModal().chooseLanguage(RUSSIAN);
    }
}
