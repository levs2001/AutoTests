package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.User;

public class LoginPage extends PresentableObject {
    private static final By SUBMIT_BUTTON_BY = By.xpath("//input[@data-l='t,sign_in']");
    private static final By EMAIL_FIELD_BY = By.id("field_email");
    private static final By PASSWORD_FIELD_BY = By.id("field_password");

    private final WebElement loginField;
    private final WebElement passwordField;
    private final WebElement submitButton;

    @Override
    protected boolean isPresent() {
        return isPresent(EMAIL_FIELD_BY, PASSWORD_FIELD_BY);
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        loginField = webDriver.findElement(EMAIL_FIELD_BY);
        passwordField = webDriver.findElement(PASSWORD_FIELD_BY);
        submitButton = webDriver.findElement(SUBMIT_BUTTON_BY);
    }

    public MainPage login(User user) {
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.submit();

        return new MainPage(webDriver);
    }
}
