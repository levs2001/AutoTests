package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.User;

class ToolbarUserDropdownTest extends BaseTest {
    private static final User TEST_USER = new User("event2", "private");
    private static final String ENGLISH = "English";
    private static final String RUSSIAN = "Русский";

    private static final String MY_SETTINGS = "My settings";

    @Test
    void changeLanguageTest() {
        MainPage mainPage = new LoginPage(webDriver).login(TEST_USER);
        mainPage.openChangeLanguageModal().chooseLanguage(ENGLISH);

        mainPage = new MainPage(webDriver);
        Assertions.assertEquals(MY_SETTINGS, mainPage.getSettingsText());

        mainPage.openChangeLanguageModal().chooseLanguage(RUSSIAN);
    }
}
