package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.User;


public class ToolbarUserDropdownTest extends BaseTest {
    private static final User TEST_USER = new User("event2", "private");

    @BeforeEach
    void before() {
        MainPage mainPage = new LoginPage(webDriver).login(TEST_USER);
        if (!mainPage.getSettingsText().equals("Мои настройки")) {
            mainPage.openChangeLanguageModal().chooseRussianLanguage();
        }
    }

    @Test
    void changeLanguageTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openChangeLanguageModal().chooseEnglishLanguage();
        // mainPage was changed, so we initialize it again
        mainPage = new MainPage(webDriver);
        Assertions.assertEquals("My settings", mainPage.getSettingsText());
    }
}
