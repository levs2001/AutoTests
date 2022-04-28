package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.LoginPage;
import pages.MainPage;
import utils.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ToolbarUserDropdownTest extends BaseTest {
    private static final String ENGLISH = "English";
    private static final String RUSSIAN = "Русский";

    private static final String MY_SETTINGS = "My settings";

    @BeforeEach
    void login() {
        new LoginPage(webDriver).login(User.fromProperties());
    }

    @Test
    void changeToEnglishLanguageTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openChangeLanguageModal().chooseLanguage(ENGLISH);

        mainPage = new MainPage(webDriver);
        assertThat("Not changed to engish language.", mainPage.getSettingsText(), equalTo(MY_SETTINGS));

        mainPage.openChangeLanguageModal().chooseLanguage(RUSSIAN);
    }
}
