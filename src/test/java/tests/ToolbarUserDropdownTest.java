package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.User;


public class ToolbarUserDropdownTest extends BaseTest {
    private static final User TEST_USER = new User("event2", "private");

    @Test
    void changeLanguageTest() {
        MainPage mainPage = new LoginPage(webDriver).login(TEST_USER);
        mainPage.openChangeLanguageModal().chooseRussianLanguage();
        Assertions.assertEquals("Мои настройки", mainPage.getSettingsText());

        mainPage.openChangeLanguageModal().chooseEnglishLanguage();
        Assertions.assertEquals("My settings", mainPage.getSettingsText());
    }
}
