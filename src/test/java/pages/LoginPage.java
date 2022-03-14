package pages;

import org.openqa.selenium.WebDriver;
import utils.User;

public class LoginPage extends Page {
    @Override
    protected boolean isPresent() {
        return false;
    }

    public LoginPage(WebDriver webDriver) throws Exception {
        super(webDriver);
    }

    public MainPage login(User user) throws Exception {
        // TODO: Логин
        return new MainPage(webDriver);
    }
}
