package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.User;

public class LoginPage extends PresentableObject {
    private static final String SUBMIT_BUTTON_XPATH = "//input[@data-l='t,sign_in']";
    private static final String EMAIL_FIELD_ID = "field_email";
    private static final String PASSWORD_FIELD_ID = "field_password";

    private final WebElement loginField;
    private final WebElement passwordField;
    private final WebElement submitButton;

    @Override
    protected boolean isPresent() {
        try {
            return webDriver.findElement(By.id(EMAIL_FIELD_ID)).isDisplayed()
                    && webDriver.findElement(By.id(PASSWORD_FIELD_ID)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        loginField = webDriver.findElement(By.id(EMAIL_FIELD_ID));
        passwordField = webDriver.findElement(By.id(PASSWORD_FIELD_ID));
        submitButton = webDriver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
    }

    public MainPage login(User user) {
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.submit();

        return new MainPage(webDriver);
    }
}
