package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.User;

public class LoginPage extends Page {
    private static final String URL = "https://ok.ru";

    @Override
    protected boolean isPresent() {
        return webDriver.findElement(By.id("login-4182275468")).isDisplayed();
    }

    public LoginPage(WebDriver webDriver) throws Exception {
        super(webDriver, URL);
    }

    public MainPage login(User user) throws Exception {
        // TODO: Логин
        return new MainPage(webDriver);
    }
}
