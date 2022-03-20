package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.User;

public class LoginPage extends PresentableObject {
    private static final String URL = "https://ok.ru";

    private final WebElement loginField;
    private final WebElement passwordField;
    private final WebElement submitButton;

    @Override
    protected boolean isPresent() {
        try {
            return webDriver.findElement(By.id("field_email")).isDisplayed()
                    && webDriver.findElement(By.id("field_password")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver, URL);
        loginField = webDriver.findElement(By.id("field_email"));
        passwordField = webDriver.findElement(By.id("field_password"));
        submitButton = webDriver.findElement(By.xpath("//input[@data-l='t,sign_in']"));
    }

    public MainPage login(User user) {
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.submit();

        return new MainPage(webDriver);
    }
}
