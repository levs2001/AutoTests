package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.User;

public class ToolbarUserDropdownTest extends BaseTest {
    private static final User TEST_USER = new User("event2", "private");

    @Test
    void changeLanguageTest() throws Exception {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(TEST_USER);
    }
}
