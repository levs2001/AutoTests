package tests;

import org.junit.jupiter.api.Test;

import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ToolbarUserDropdownTest extends BaseTest {
    private static final String ENGLISH = "English";
    private static final String RUSSIAN = "Русский";

    private static final String MY_SETTINGS = "My settings";

    @Test
    void changeLanguageTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.openChangeLanguageModal().chooseLanguage(ENGLISH);

        mainPage = new MainPage(webDriver);
        assertThat(mainPage.getSettingsText(), equalTo(MY_SETTINGS));

        mainPage.openChangeLanguageModal().chooseLanguage(RUSSIAN);
    }
}
